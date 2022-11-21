package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RectangularMapTest {
    final int width = 5;
    final int height = 5;

    @Test
    void canMoveToTest() {
        RectangularMap map = new RectangularMap(this.width, this.height);

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
        assertFalse(map.place(new Animal(map, new Vector2d(this.width+1, this.height))));
        assertFalse(map.place(new Animal(map, new Vector2d(this.width-1, this.height+1))));
    }

    @Test
    void isOccupiedTest() {
        RectangularMap map = new RectangularMap(this.width, this.height);
        Animal animal1 = new Animal(map, new Vector2d(0, 0));
        Animal animal2 = new Animal(map, new Vector2d(2, 2));
        Animal animal3 = new Animal(map, new Vector2d(3, 4));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertEquals(animal1, map.objectAt(animal1.getPosition()));
        assertNotEquals(animal2, map.objectAt(animal1.getPosition()));
        assertNotEquals(animal2, map.objectAt(animal3.getPosition()));
        assertNull(map.objectAt(new Vector2d(this.width, this.height)));
        assertNotNull(map.objectAt(animal3.getPosition()));
    }
}
