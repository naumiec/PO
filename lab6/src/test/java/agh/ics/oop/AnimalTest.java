package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {
    OptionsParser optionsParser = new OptionsParser();

    @Test
    void getPositionTest() {
        assertEquals(new Vector2d(0,0), new Animal().getPosition());
        assertEquals(new Vector2d(2,2), new Animal(new Vector2d(2, 2)).getPosition());
        assertNotEquals(new Vector2d(2,2), new Animal(new Vector2d(3, 4)).getPosition());
        assertNotEquals(new Vector2d(1,2), new Animal(new Vector2d(3, 4)).getPosition());
    }

    @Test
    void getOrientationTest() {
        assertEquals(new Animal().getOrientation(), MapDirection.NORTH);
        assertEquals(new Animal(MapDirection.WEST).getOrientation(), MapDirection.WEST);
        assertNotEquals(new Animal(MapDirection.SOUTH).getOrientation(), MapDirection.WEST);
        assertNotEquals(new Animal(MapDirection.EAST).getOrientation(), MapDirection.WEST);
    }

    @Test
    void moveTest() {
        assertEquals(new Vector2d(0, 0), new Animal().getPosition());
        assertEquals(new Vector2d(0, 3), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"f", "forward", "f"})).getPosition());
        assertEquals(MapDirection.NORTH, new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"f"})).getOrientation());
        assertEquals(MapDirection.WEST, new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"r", "r", "right"})).getOrientation());
    }
}
