package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractWorldMap implements IWorldMap {
    protected final List<AbstractWorldMapElement> mapElements = new ArrayList<>();
    //protected List<Animal> animalList = new ArrayList<>();
    //protected List<Grass> grassList = new ArrayList<>();

    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerLeftCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRightCorner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);

        /*
        if (lowerLeftCorner.precedes(position) && upperRightCorner.follows(position)) {
            return !(objectAt(position) instanceof Animal);
        } else {
            return false;
        }
         */
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.mapElements.add(animal);
            return true;
        }

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (AbstractWorldMapElement mapElement : this.mapElements) {
            if (mapElement.getPosition().equals(position)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public AbstractWorldMapElement objectAt(Vector2d position) {
        for (AbstractWorldMapElement mapElement : this.mapElements) {
            if (mapElement.getPosition().equals(position)) {
                return mapElement;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }
}
