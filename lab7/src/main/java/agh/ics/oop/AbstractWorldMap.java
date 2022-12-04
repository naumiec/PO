package agh.ics.oop;

import java.util.*;


public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, AbstractWorldMapElement> mapElements = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerLeftCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRightCorner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.mapElements.get(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        if (canMoveTo(animal.getPosition())) {
            this.mapElements.put(animal.getPosition(), animal);
            return true;
        } else {
            throw new IllegalArgumentException("Position " + animal.getPosition() + " is already occupied");
            // throw new IllegalArgumentException instead of returning false
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return mapElements.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return mapElements.get(position);
        // if empty - HashMap.get() returns null
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }

    public Map<Vector2d, AbstractWorldMapElement> getMapElements() {
        return mapElements;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement mapElementToChange = this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition, mapElementToChange);
    }
}
