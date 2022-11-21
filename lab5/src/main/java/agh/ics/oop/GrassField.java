package agh.ics.oop;

import static java.lang.Math.*;


public class GrassField extends AbstractWorldMap implements IWorldMap {
    int numberOfGrassTufts;

    int maxRangeOfGrassTufts;
    int minRangeOfGrassTufts;
    Vector2d vectorMaxRangeOfGrassTufts;
    Vector2d vectorMinRangeOfGrassTufts;

    public GrassField(int numberOfGrassTufts) {
        this.numberOfGrassTufts = numberOfGrassTufts;

        this.maxRangeOfGrassTufts = (int) ceil(sqrt(numberOfGrassTufts * 10));
        this.minRangeOfGrassTufts = 0;

        this.vectorMaxRangeOfGrassTufts = new Vector2d(this.maxRangeOfGrassTufts, this.maxRangeOfGrassTufts);
        this.vectorMinRangeOfGrassTufts = new Vector2d(this.minRangeOfGrassTufts, this.minRangeOfGrassTufts);

        for (int i = 0; i < numberOfGrassTufts; i++) {
            Vector2d newGrassPosition;

            do {
                newGrassPosition = new Vector2d((int) (random() * this.maxRangeOfGrassTufts), (int) (random() * this.maxRangeOfGrassTufts));
            } while (this.isOccupied(newGrassPosition));

            this.mapElements.add(new Grass(newGrassPosition));
            //this.grassList.add(new Grass(newGrassPosition));
        }
    }

    public int getRandomNumberInRange(double minRange, double maxRange) {
        return (int) ((random() * (maxRange - minRange)) + minRange);
    }

    public void spawnGrass() {
        Vector2d newPosition;

        do {
            int x = getRandomNumberInRange(this.minRangeOfGrassTufts, this.maxRangeOfGrassTufts);
            int y = getRandomNumberInRange(this.minRangeOfGrassTufts, this.maxRangeOfGrassTufts);
            newPosition = new Vector2d(x, y);
        } while (objectAt(newPosition) != null);

        this.mapElements.add(new Grass(newPosition));
        //this.grassList.add(new Grass(newPosition));
    }

    public void eatGrass(Vector2d positionOfGrass, Object objectGrass) {
        this.mapElements.remove(objectGrass);
        //this.grassList.remove(objectGrass);
    }

    @Override
    public String toString() {
        for (AbstractWorldMapElement mapElement : this.mapElements) {
            this.upperRightCorner = this.upperRightCorner.upperRight(mapElement.getPosition());
            this.lowerLeftCorner = this.lowerLeftCorner.lowerLeft(mapElement.getPosition());
        }

        return super.toString();
    }
}
