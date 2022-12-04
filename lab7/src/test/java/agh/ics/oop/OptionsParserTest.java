/*
package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import static agh.ics.oop.MoveDirection.*;
import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;


class OptionsParserTest {
    OptionsParser parser = new OptionsParser();

    @Test
    void parseTest() {
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD}, (parser.parse(new String[]{"f"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD, RIGHT, BACKWARD, LEFT}, (parser.parse(new String[]{"f", "r", "b", "l"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD, FORWARD, FORWARD}, (parser.parse(new String[]{"forward", "forward", "forward"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD, RIGHT, BACKWARD, LEFT}, (parser.parse(new String[]{"forward", "right", "backward", "left"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD, BACKWARD}, (parser.parse(new String[]{"f", "backward"})).toArray());

        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(new String[]{"f", "x", "F", "forforward"}));
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(new String[]{"b", "X", "x", "", "-", "backward"}));
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(new String[]{"test", "tset", "0", "null", "nill", "None"}));
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(new String[]{"forward", "backward", "right", "left", "test"}));
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(new String[]{"left", "right", "l", "r", "left left", "right right", "left ", "   right"}));
    }
}
*/
