/*
package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.*;


class GrassFieldTest {
    @Test
    void canMoveToTest() {
        GrassField map = new GrassField(0);

        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(-1, -1)));
        assertTrue(map.canMoveTo(new Vector2d(MAX_VALUE-1, MAX_VALUE-1)));
        assertTrue(map.canMoveTo(new Vector2d(0, MIN_VALUE+1)));

        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map);
        map.place(animal1);
        map.place(animal2);

        assertFalse(map.canMoveTo(animal1.getPosition()));
        assertFalse(map.canMoveTo(animal2.getPosition()));
    }

    @Test
    void placeTest() {
        GrassField map = new GrassField(10);

        assertTrue(map.place(new Animal(map)));
        assertTrue(map.place(new Animal(map, new Vector2d(3, 4))));

        assertThrows(IllegalArgumentException.class,
                () -> map.place(new Animal(map)));
        assertThrows(IllegalArgumentException.class,
                () -> map.place(new Animal(map, new Vector2d(0, 0))));
    }

    @Test
    void isOccupiedTest() {
        GrassField map = new GrassField(0);

        assertFalse(map.isOccupied((new Animal(map)).getPosition()));
        map.place(new Animal(map));
        assertTrue(map.isOccupied((new Animal(map)).getPosition()));

        map.place(new Animal(map, new Vector2d(3, 4)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));

        assertFalse(map.isOccupied(new Vector2d(2,2)));
    }

    @Test
    void objectAtTest() {
        GrassField map = new GrassField(0);

        Animal animal = new Animal(map);
        map.place(animal);

        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNotNull(map.objectAt(animal.getPosition()));

        assertNull(map.objectAt(new Vector2d(2, 2)));
        map.place(new Animal(map, new Vector2d(2, 2)));
        assertNotNull(map.objectAt(new Vector2d(2, 2)));
    }
}
*/
