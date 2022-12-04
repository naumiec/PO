package agh.ics.oop;

import java.util.List;


public class OptionsParser {
    public MoveDirection[] parse(List<String> args) throws IllegalArgumentException {
        int n = args.size();
        MoveDirection[] directionsArray = new MoveDirection[n];

        for (int i = 0; i < n; i++) {
            switch (args.get(i)) {
                case "f", "forward" -> directionsArray[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directionsArray[i] = MoveDirection.BACKWARD;
                case "r", "right" -> directionsArray[i] = MoveDirection.RIGHT;
                case "l", "left" -> directionsArray[i] = MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(args.get(i) + " is not legal move specification!\n" +
                        "Choose from: f, forward, b, backward, r, right, l, left.");
            }
        }

        return directionsArray;
    }
}
