/*
package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SimulationEngineTest {
    @Test
    void runTest() {
        int height = 10;
        int width = 5;
        AbstractWorldMap map = new RectangularMap(width, height, boundary);

        String[] moves = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(moves);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        positions.add(new Vector2d(3, 4));

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Vector2d> expectedPositions = new ArrayList<>(Arrays.asList(new Vector2d(2, 0), new Vector2d(3, 4)));                                                          assertTrue(map.canMoveTo(new Vector2d(0, 0)));

        if (expectedPositions.equals(((SimulationEngine) engine).getAnimalsPositions())) {
            assertEquals(expectedPositions, ((SimulationEngine) engine).getAnimalsPositions());
        } else {
            assertNotEquals(expectedPositions, ((SimulationEngine) engine).getAnimalsPositions());
        }

    }
}
*/
