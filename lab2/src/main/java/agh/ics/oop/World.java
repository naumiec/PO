package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.print("---START---\n");

        //./gradlew run --args="f l"
        Direction[] directions = new Direction[args.length];
        getDirections(args, directions);
        printDirections(directions);

        //./gradlew run
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println("Add vector1 and vector2:");
        System.out.println(position1.add(position2));

        System.out.print("---STOP---\n");
    }

    private static void getDirections(String[] args, Direction[] dirs) {
        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "f" -> dirs[i] = Direction.FORWARD;
                case "b" -> dirs[i] = Direction.BACKWARD;
                case "l" -> dirs[i] = Direction.LEFT;
                case "r" -> dirs[i] = Direction.RIGHT;
                default -> dirs[i] = Direction.UNKNOWN;
            }
        }
    }

    private static void printDirections(Direction[] directions) {
        for (Direction direction : directions) {
            String message = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu.";
                case BACKWARD -> "Zwierzak idzie do tyłu.";
                case RIGHT -> "Zwierzak skręca w prawo.";
                case LEFT -> "Zwierzak skręca w lewo.";
                case UNKNOWN -> "Błędny argument!";
            };

            System.out.println(message);
        }
    }
}
