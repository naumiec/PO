package agh.ics.oop;



public class World {
    public static void main(String[] args) {
        //System.out.print("system wystartował\n");
        System.out.print("---START---\n");

        //./gradlew run --args="f l"
        Direction[] directions = new Direction[args.length];
        getDirections(args, directions);
        printDirections(directions);
        //run(args);

        /*System.out.print("---DANE TESTOWE---\n");
        String[] argumenty = new String[] {"f", "f", "r", "b", "l", "x"};
        Direction[] kierunki = new Direction[argumenty.length];
        getDirections(argumenty, kierunki);
        printDirections(kierunki);*/

        System.out.print("---STOP---\n");
        //System.out.print("system zakończył działanie\n");
    }


    private static void getDirections(String[] args, Direction[] dirs) {
        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "f"    -> dirs[i] = Direction.FORWARD;
                case "b"    -> dirs[i] = Direction.BACKWARD;
                case "l"    -> dirs[i] = Direction.LEFT;
                case "r"    -> dirs[i] = Direction.RIGHT;

                default     -> dirs[i] = Direction.INVALID_ARG;
            }
        }
    }


    private static void printDirections(Direction[] directions) {
        for (Direction direction : directions) {
            String message = switch (direction) {
                case FORWARD        -> "Zwierzak idzie do przodu.";
                case BACKWARD       -> "Zwierzak idzie do tyłu.";
                case RIGHT          -> "Zwierzak skręca w prawo.";
                case LEFT           -> "Zwierzak skręca w lewo.";

                case INVALID_ARG    -> "Błędny argument!";
            };

            System.out.println(message);
        }
    }


    private static void run_old2(String[] arguments) {
        for (String argument : arguments) {
            String message = switch (argument) {
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do tyłu";
                case "r" -> "Zwierzak skręca w prawo";
                case "l" -> "Zwierzak skręca w lewo";

                default -> "Nieznana komenda";
            };

            System.out.print(message + "\n");
        }
    }


    private static void run_old1(String[] arguments) {
        if (arguments.length < 3) {
            System.out.print("Podano za malo argumentow\n");
            return;
        }

        System.out.print("Zwierzak idzie do przodu\n");

        for (int i = 0; i < arguments.length; ++i) {
            System.out.print(arguments[i]);

            if (i != arguments.length-1) {
                System.out.print(", ");
            }
        }

        System.out.print("\n");
    }
}
