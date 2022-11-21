package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class RectangularMap implements IWorldMap{
    private final Vector2d leftLowerCorner;
    private final Vector2d rightUpperCorner;
    private final int width;
    private final int height;
    private final List<Animal> animals = new ArrayList<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.leftLowerCorner = new Vector2d(0, 0);
        this.rightUpperCorner = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (leftLowerCorner.precedes(position) && rightUpperCorner.follows(position)) {
            return !isOccupied(position);
        }

        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if ( !leftLowerCorner.precedes(animal.getPosition()) || !rightUpperCorner.follows(animal.getPosition()) ) {
            return false;
        }

        if (isOccupied(animal.getPosition())) {
            return false;
        }

        this.animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.leftLowerCorner, this.rightUpperCorner);
    }
}
