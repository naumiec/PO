package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {
    OptionsParser parser = new OptionsParser();

    @Test
    void orientationTest() {
        assertEquals(MapDirection.NORTH, new Animal().getOrientation());
        assertEquals(MapDirection.EAST, new Animal().move(parser.parse(new String[]{"r"})).getOrientation());
        assertEquals(MapDirection.NORTH, new Animal().move(parser.parse(new String[]{"r", "r", "r", "r"})).getOrientation());
        assertEquals(MapDirection.WEST, new Animal().move(parser.parse(new String[]{"l"})).getOrientation());
        assertEquals(MapDirection.SOUTH, new Animal().move(parser.parse(new String[]{"l", "l"})).getOrientation());
        assertEquals(MapDirection.NORTH, new Animal().move(parser.parse(new String[]{"f"})).getOrientation());
    }

    @Test
    void positionParseTest() {
        assertEquals(new Vector2d(2, 4), new Animal().move(parser.parse(new String[] {"f", "f", "f"})).getPosition());
        assertEquals(new Vector2d(2, -4), new Animal().move(parser.parse(new String[] {"b", "b", "b", "b", "b", "b", "b"})).getPosition());
        assertEquals(new Vector2d(4, 4), new Animal().move(parser.parse(new String[] {"f", "f", "f", "r", "f", "f", "f"})).getPosition());
        assertEquals(new Vector2d(-4, -4), new Animal().move(parser.parse(new String[] {"b", "b", "b", "b", "b", "b", "b", "l", "f", "f", "f", "f", "f", "f", "f"})).getPosition());
    }

    @Test
    void inMapTest() {
        assertEquals(new Vector2d(2, 2), new Animal().getPosition());
        assertEquals(new Vector2d(3, 3), new Animal().move(parser.parse(new String[]{"f", "r", "f"})).getPosition());
        assertEquals(new Vector2d(3, 4), new Animal().move(parser.parse(new String[]{"f", "f", "r", "f"})).getPosition());
        assertEquals(new Vector2d(2, 1), new Animal().move(parser.parse(new String[]{"b"})).getPosition());
        assertEquals(new Vector2d(2, 1), new Animal().move(parser.parse(new String[]{"r", "r", "f"})).getPosition());
    }
}
