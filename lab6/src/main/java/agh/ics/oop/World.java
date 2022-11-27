package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class World {
    //public static void main(int numOfGrass, String[] args) {
    public static void main(String[] args) {
        System.out.print("---START---\n");
        //List<MoveDirection> directions = new OptionsParser().parse(args);
        //AbstractWorldMap map = new GrassField(numOfGrass);

        int numberOfGrassTufts = 10;
        AbstractWorldMap map = new GrassField(numberOfGrassTufts);

        String[] moves = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(moves);

        Vector2d[] startPositions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        List<Vector2d> positions = new ArrayList<>(Arrays.asList(startPositions));

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.print("---STOP---\n");
    }
}
