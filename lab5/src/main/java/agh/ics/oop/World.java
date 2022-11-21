package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class World {
    // public static void main(String[] args, int numOfGrass) {
    public static void main(String[] args) {
        System.out.print("---START---\n");

        int numberOfGrassTufts = 10;
        AbstractWorldMap map = new GrassField(numberOfGrassTufts);

        String[] moves = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(moves);
        List<MoveDirection> directionsArgs = new OptionsParser().parse(args);

        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        positions.add(new Vector2d(3, 4));

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.print("---STOP---\n");
    }
}
