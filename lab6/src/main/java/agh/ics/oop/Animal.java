package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class Animal extends AbstractWorldMapElement implements IMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map) {
        //super(position);
        this.map = map;
        this.addObserver(this.map);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        //super(position);
        this.position = initialPosition;
        this.map = map;
        this.addObserver(this.map);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition, MapDirection orientation) {
        //super(position);
        this.orientation = orientation;
        this.position = initialPosition;
        this.map = map;
        this.addObserver(this.map);
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
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();

            case FORWARD, BACKWARD -> {
                Vector2d newPosition = this.position;

                if (direction == MoveDirection.FORWARD) {
                    newPosition = this.position.add(this.orientation.toUnitVector());
                }

                if (direction == MoveDirection.BACKWARD) {
                    newPosition = this.position.subtract(this.orientation.toUnitVector());
                }

                if (this.map.canMoveTo(newPosition)) {
                    Object objectAtPosition = this.map.objectAt(newPosition);

                    if (objectAtPosition == null) {
                        positionChanged(this.position, newPosition);
                        this.position = newPosition;
                    }

                    if (objectAtPosition instanceof Grass) {
                        ((GrassField) this.map).eatGrass(newPosition);
                        ((GrassField) this.map).spawnGrass();

                        positionChanged(this.position, newPosition);
                        this.position = newPosition;
                    }

                    //if (objectAtPosition instanceof Animal) - nie rób nic
                }
            }
        }

        return this;
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.observers.forEach(observer -> observer.positionChanged(oldPosition, newPosition));
    }

    public Animal move(ArrayList<MoveDirection> directions) {
        for (MoveDirection direction : directions)
            this.move(direction);

        return this;
    }

    //do testowania rozwiązań
    public Animal() {
        this.position = new Vector2d(0, 0);
        this.map = new RectangularMap(10, 10);
        this.addObserver(this.map);
    }

    //do testowania rozwiązań
    public Animal(Vector2d position) {
        this.position = position;
        this.map = new RectangularMap(10, 10);
        this.addObserver(this.map);
    }

    //do testowania rozwiązań
    public Animal(MapDirection direction) {
        this.orientation = direction;
        this.map = new RectangularMap(10, 10);
        this.addObserver(this.map);
    }
}
