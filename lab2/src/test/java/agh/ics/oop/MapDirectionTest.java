package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    void nextTest() {
        assertEquals(NORTH, WEST.next());
        assertEquals(WEST, SOUTH.next());
        assertEquals(SOUTH, EAST.next());
        assertEquals(EAST, NORTH.next());
    }

    @Test
    void previousTest() {
        assertEquals(NORTH, EAST.previous());
        assertEquals(EAST, SOUTH.previous());
        assertEquals(SOUTH, WEST.previous());
        assertEquals(WEST, NORTH.previous());
    }
}