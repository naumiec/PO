package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    private final Vector2d leftBottomCorner = new Vector2d(0, 0);
    private final Vector2d rightUpperCorner;
    private final MapBoundary boundary;
    int width;
    int height;

    public RectangularMap(int width, int height, MapBoundary boundary) {
        this.boundary = boundary;
        this.rightUpperCorner = new Vector2d(width - 1, height - 1);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (lowerLeftCorner.precedes(position) && upperRightCorner.follows(position)) {
            return super.canMoveTo(position);
        }

        return false;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) mapElements.remove(oldPosition);
        mapElements.put(newPosition, animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return mapElements.get(position);
    }
}
