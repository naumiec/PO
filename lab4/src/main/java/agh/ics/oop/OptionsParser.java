package agh.ics.oop;


public class OptionsParser {
    public MoveDirection[] parse(String[] args) {
        MoveDirection directions[] = new MoveDirection[args.length];
        int numberOfUnknown = 0;

        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "f", "forward" -> directions[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[i] = MoveDirection.BACKWARD;
                case "r", "right" -> directions[i] = MoveDirection.RIGHT;
                case "l", "left" -> directions[i] = MoveDirection.LEFT;
                default -> {
                    directions[i] = MoveDirection.UNKNOWN;
                    numberOfUnknown++;
                }
            }
        }

        int resultLength = args.length - numberOfUnknown;
        MoveDirection[] resultDirections = new MoveDirection[resultLength];

        int j = 0;
        for (int i = 0; i < args.length; ++i) {
            if (directions[i] != MoveDirection.UNKNOWN) {
                resultDirections[j] = directions[i];
                j++;
            }
        }

        return resultDirections;
    }
}
