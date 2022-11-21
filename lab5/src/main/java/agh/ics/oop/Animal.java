package agh.ics.oop;

import java.util.ArrayList;


public class Animal extends AbstractWorldMapElement implements IMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;

    public Animal(AbstractWorldMap map) {
        //super(position);
        this.map = map;
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        //super(position);
        this.position = initialPosition;
        this.map = map;
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition, MapDirection orientation) {
        //super(position);
        this.orientation = orientation;
        this.position = initialPosition;
        this.map = map;
    }

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

    /*
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    */

    public Animal move(MoveDirection direction) {
        Vector2d newPosition = this.position;

        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();

            case FORWARD, BACKWARD -> {
                if (direction == MoveDirection.FORWARD) {
                    newPosition = this.position.add(this.orientation.toUnitVector());
                }

                if (direction == MoveDirection.BACKWARD) {
                    newPosition = this.position.subtract(this.orientation.toUnitVector());
                }

                if (this.map.canMoveTo(newPosition)) {
                    Object objectAt = this.map.objectAt(newPosition);

                    if (objectAt == null) {
                        this.position = newPosition;
                    }

                    if (objectAt instanceof Grass) {
                        this.position = newPosition;
                        ((GrassField) this.map).eatGrass(newPosition, objectAt);
                        ((GrassField) this.map).spawnGrass();
                    }
                }
            }
        }

        return this;
    }

    public Animal move(ArrayList<MoveDirection> directions) {
        for (MoveDirection direction : directions)
            this.move(direction);

        return this;
    }

    // do testowania rozwiązań
    public Animal() {
        this.position = new Vector2d(0, 0);
        this.map = new RectangularMap(10, 10);
    }

    // do testowania rozwiązań
    public Animal(Vector2d position) {
        this.position = position;
        this.map = new RectangularMap(10, 10);
    }

    // do testowania rozwiązań
    public Animal(MapDirection direction) {
        this.orientation = direction;
        this.map = new RectangularMap(10, 10);
    }
}
