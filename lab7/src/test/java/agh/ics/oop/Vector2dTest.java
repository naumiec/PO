/*
package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {

    @Test
    void toStringTest() {
        assertEquals("(3,5)", new Vector2d(3, 5).toString());
        assertNotEquals("(5,3)", new Vector2d(3, 5).toString());
        assertNotEquals("(5,3)", new Vector2d(1, 5).toString());
    }

    @Test
    void precedesTest() {
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d vector3 = new Vector2d(4, 7);

        assertTrue(vector1.precedes(vector2));
        assertTrue(vector1.precedes(vector3));
        assertTrue(vector3.precedes(vector3));
        assertTrue(vector2.precedes(vector3));
        assertFalse(vector3.precedes(vector2));
    }

    @Test
    void followsTest() {
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d vector3 = new Vector2d(4, 7);

        assertTrue(vector2.follows(vector1));
        assertTrue(vector3.follows(vector1));
        assertTrue(vector3.follows(vector2));
        assertTrue(vector2.follows(vector2));
        assertFalse(vector1.follows(vector2));
    }

    @Test
    void addTest() {
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(3, 4);
        Vector2d vector3 = new Vector2d(5, -1);

        assertEquals(vector1.add(vector2), new Vector2d(4, 5));
        assertEquals(vector1.add(vector3), new Vector2d(6, 0));
        assertEquals(vector2.add(vector3), new Vector2d(8, 3));
    }

    @Test
    void subtractTest() {
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(3, 4);
        Vector2d vector3 = new Vector2d(5, -1);

        assertEquals(vector2.subtract(vector1), new Vector2d(2, 3));
        assertEquals(vector3.subtract(vector1), new Vector2d(4, -2));
        assertEquals(vector2.subtract(vector3), new Vector2d(-2, 5));
    }

    @Test
    void upperRightTest() {
        assertEquals(new Vector2d(3, 3), new Vector2d(0, 3).upperRight(new Vector2d(3, 1)));
        assertEquals(new Vector2d(1, 1), new Vector2d(-10, 0).upperRight(new Vector2d(1, 1)));
        assertEquals(new Vector2d(4, 5), new Vector2d(4, 4).upperRight(new Vector2d(4, 5)));
    }

    @Test
    void lowerLeftTest() {
        assertEquals(new Vector2d(-1, 0), new Vector2d(-1, 3).lowerLeft(new Vector2d(0, 0)));
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0).lowerLeft(new Vector2d(11, 10)));
        assertEquals(new Vector2d(4, 5), new Vector2d(4, 10).lowerLeft(new Vector2d(10, 5)));
    }

    @Test
    void oppositeTest() {
        assertEquals(new Vector2d(-3, -3), new Vector2d(3, 3).opposite());
        assertEquals(new Vector2d(-3, -5), new Vector2d(3, 5).opposite());
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0).opposite());
    }

    @Test
    void EqualsTest() {
        assertEquals(new Vector2d(7, 7), new Vector2d(3, 4).add(new Vector2d(4, 3)));
        assertEquals(new Vector2d(7, 7), new Vector2d(10, 11).add(new Vector2d(-3, -4)));
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 2).add(new Vector2d(0, 0)));
    }
}
*/
