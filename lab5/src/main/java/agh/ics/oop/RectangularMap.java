package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    private final List<Animal> animals = new ArrayList<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);
    int width;
    int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperRightCorner = new Vector2d(width-1, height-1);
        this.lowerLeftCorner = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (lowerLeftCorner.precedes(position) && upperRightCorner.follows(position)) {
            return super.canMoveTo(position);
        }

        return false;
    }
}
