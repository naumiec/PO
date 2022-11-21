package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RectangularMapTest {
    final int width = 5;
    final int height = 5;
    RectangularMap map = new RectangularMap(this.width, this.height);

    @Test
    void canMoveToTest() {
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertFalse(map.canMoveTo(new Vector2d(-1, -1)));
        assertTrue(map.canMoveTo(new Vector2d(this.width-1, this.height-1)));
        assertFalse(map.canMoveTo(new Vector2d(this.width, 0)));
        assertFalse(map.canMoveTo(new Vector2d(0, this.height)));
        assertFalse(map.canMoveTo(new Vector2d(-1, 0)));
        assertFalse(map.canMoveTo(new Vector2d(0, -1)));
    }

    @Test
    void placeTest() {
        RectangularMap map = new RectangularMap(this.width, this.height);

        assertTrue(map.place(new Animal(map, new Vector2d(0, 0))));
        assertTrue(map.place(new Animal(map, new Vector2d(this.width-1, this.height-1))));
    }

    @Test
    void isOccupiedTest() {
        RectangularMap map = new RectangularMap(this.width, this.height);
        Animal animal = new Animal(map);

        assertFalse(map.isOccupied(new Vector2d(0, 0)));
        assertFalse(map.isOccupied(new Vector2d(this.width-1, this.height-1)));
    }

    @Test
    void objectAtTest() {
        RectangularMap map = new RectangularMap(this.width, this.height);

        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        positions.add(new Vector2d(3, 4));

        List<MoveDirection> directions = new ArrayList<>();

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertNotNull(map.objectAt(new Vector2d(2, 2)));
        assertNotNull(map.objectAt(new Vector2d(2, 2)));
        assertNull(map.objectAt(new Vector2d(0, 0)));
        assertNull(map.objectAt(new Vector2d(this.width-1, this.height-1)));
    }
}
