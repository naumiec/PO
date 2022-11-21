package agh.ics.oop;

import java.util.ArrayList;


public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public Vector2d getPosition() { return this.position; }
    public MapDirection getOrientation() { return this.orientation; }

    @Override
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
            case UNKNOWN -> null;
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction) {
        Vector2d newPosition = this.position;

        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT ->this. orientation = this.orientation.previous();
            case FORWARD -> newPosition = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.orientation.toUnitVector());
        }

        if (this.map.canMoveTo(newPosition)) {
            position = newPosition;
        }

        return this;
    }

    public Animal move(MoveDirection[] directions) {
        for (MoveDirection direction : directions)
            this.move(direction);

        return this;
    }
}
