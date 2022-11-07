package agh.ics.oop;


import java.util.ArrayList;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private static final Vector2d upperRightCorner = new Vector2d(4, 4);
    private static final Vector2d lowerLeftCorner = new Vector2d(-4, -4);

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    @Override
    public String toString() {
        return String.format("Pozycja: %s\nOrientacja: %s", position.toString(), orientation.toString());
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction) {
        Vector2d newPosition = position;

        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> newPosition = position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition = position.subtract(orientation.toUnitVector());
        }

        if (newPosition.precedes(upperRightCorner) && newPosition.follows(lowerLeftCorner)) {
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
