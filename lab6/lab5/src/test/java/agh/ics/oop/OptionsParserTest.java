package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static agh.ics.oop.MoveDirection.*;
import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;


class OptionsParserTest {
    OptionsParser parser = new OptionsParser();

    @Test
    void parseTest() {
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD}, (parser.parse(new String[]{"f"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD}, (parser.parse(new String[]{"f", "x", "F", "forforward"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{BACKWARD, BACKWARD}, (parser.parse(new String[]{"b", "X", "x", "", "-", "backward"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{}, (parser.parse(new String[]{"test", "tset", "0", "null", "nill", "None"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{FORWARD, BACKWARD, RIGHT, LEFT}, (parser.parse(new String[]{"forward", "backward", "right", "left"})).toArray());
        Assertions.assertArrayEquals(new MoveDirection[]{LEFT, RIGHT, LEFT, RIGHT}, (parser.parse(new String[]{"left", "right", "l", "r", "left left", "right right", "left ", "   right"})).toArray());
    }
}
