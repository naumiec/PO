package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SimulationEngineTest {
    @Test
    void runTest1() {
        int height = 10;
        int width = 5;
        IWorldMap map = new RectangularMap(width, height);
        String[] moves = new String[]{};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        positions.add(new Vector2d(3, 4));
        List<Vector2d> expectedPositions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));

        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Vector2d> receivedPositions = engine.getAnimalsPositionsList();

        assertEquals(receivedPositions, expectedPositions);
    }

    @Test
    void runTest2() {
        int height = 10;
        int width = 5;
        IWorldMap map = new RectangularMap(width, height);
        String[] moves = new String[]{"f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        positions.add(new Vector2d(3, 4));
        List<Vector2d> expectedPositions = new ArrayList<>(Arrays.asList(new Vector2d(2, 3), new Vector2d(3, 5)));

        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Vector2d> receivedPositions = engine.getAnimalsPositionsList();

        assertEquals(receivedPositions, expectedPositions);
    }

    @Test
    void runTest3() {
        int height = 10;
        int width = 10;
        IWorldMap map = new RectangularMap(width, height);
        String[] moves = new String[]{"f", "r", "f", "r", "f", "r", "f", "r", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0, 0));
        positions.add(new Vector2d(0, 0));
        positions.add(new Vector2d(1, 1));
        List<Vector2d> expectedPositions = new ArrayList<>(Arrays.asList(new Vector2d(0, 5), new Vector2d(1, 2)));

        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Vector2d> receivedPositions = engine.getAnimalsPositionsList();

        assertEquals(receivedPositions, expectedPositions);
    }

    @Test
    void runTest4() {
        int height = 10;
        int width = 10;
        IWorldMap map = new RectangularMap(width, height);
        String[] moves = new String[]{"f", "b", "r", "r", "f", "b", "l", "l",
                "f", "b", "r", "r", "f", "b", "l", "l",
                "f", "b", "r", "r", "f", "b", "l", "l",
                "f", "b", "r", "r", "f", "b", "l", "l"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0, 0));
        positions.add(new Vector2d(9, 9));
        List<Vector2d> expectedPositions = new ArrayList<>(Arrays.asList(new Vector2d(4, 4), new Vector2d(5, 5)));

        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Vector2d> receivedPositions = engine.getAnimalsPositionsList();

        assertEquals(receivedPositions, expectedPositions);
    }
}
