package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Math.*;


public class GrassField extends AbstractWorldMap implements IWorldMap {
    private final MapBoundary boundary;
    private final int numberOfGrassTufts;

    int maxRangeOfGrassTufts;
    int minRangeOfGrassTufts;
    Vector2d vectorMaxRangeOfGrassTufts;
    Vector2d vectorMinRangeOfGrassTufts;

    public GrassField(int numberOfGrassTufts, MapBoundary boundary) {
        this.numberOfGrassTufts = numberOfGrassTufts;
        this.boundary = boundary;

        this.maxRangeOfGrassTufts = (int) ceil(sqrt(numberOfGrassTufts * 10));
        this.minRangeOfGrassTufts = 0;

        this.vectorMaxRangeOfGrassTufts = new Vector2d(this.maxRangeOfGrassTufts, this.maxRangeOfGrassTufts);
        this.vectorMinRangeOfGrassTufts = new Vector2d(this.minRangeOfGrassTufts, this.minRangeOfGrassTufts);

        for (int i = 0; i < numberOfGrassTufts; i++) {
            spawnGrass();
        }
    }

    public void spawnGrass() {
        Vector2d newGrassPosition;

        do {
            int x = getRandomNumberInRange(this.minRangeOfGrassTufts, this.maxRangeOfGrassTufts);
            int y = getRandomNumberInRange(this.minRangeOfGrassTufts, this.maxRangeOfGrassTufts);
            newGrassPosition = new Vector2d(x, y);
        } while (this.isOccupied(newGrassPosition));

        Grass newGrass = new Grass(newGrassPosition);
        this.mapElements.put(newGrassPosition, newGrass);
        this.boundary.addVector(newGrassPosition);

        // for testing purposes
        // animals are spawned first, so they have priority in being placed on the map at the start
        //this.mapElements.put(newGrassPosition, new Grass(new Vector2d(2,2)));
    }

    public void eatGrass(Vector2d positionOfGrass) {
        this.mapElements.remove(positionOfGrass);
        this.boundary.removeVector(positionOfGrass);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (super.canMoveTo(position)) {
            if (objectAt(position) instanceof Grass) {
                this.eatGrass(position);
                this.spawnGrass();
            }
            return true;
        }

        return false;
    }

    public int getRandomNumberInRange(double minRange, double maxRange) {
        return (int) ((random() * (maxRange - minRange)) + minRange);
    }

    @Override
    public String toString() {
        this.upperRightCorner = this.boundary.getUpperRightCorner();
        this.lowerLeftCorner = this.boundary.getLowerLeftCorner();

        return super.toString();
        //return mapVisualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }

    public Object objectAt(Vector2d position) {
        return this.mapElements.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement mapElement = this.mapElements.get(oldPosition);
        this.mapElements.put(newPosition, mapElement);
        this.boundary.positionChanged(oldPosition, newPosition);
        this.mapElements.remove(oldPosition);
    }
}
