package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, AbstractWorldMapElement> mapElements = new HashMap<>();
    //protected List<AbstractWorldMapElement> mapElements = new ArrayList<>();

    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerLeftCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRightCorner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.mapElements.put(animal.getPosition(), animal);
            return true;
        }

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return mapElements.get(position) != null;
    }

    @Override
    public AbstractWorldMapElement objectAt(Vector2d position) {
        return mapElements.get(position); //jeśli puste - HashMap.get() zwraca null
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement mapElementToChange = this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition, mapElementToChange);
    }
}
