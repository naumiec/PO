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
            spawnGrass();
        }
    }

    public int getRandomNumberInRange(double minRange, double maxRange) {
        return (int) ((random() * (maxRange - minRange)) + minRange);
    }

    public void spawnGrass() {
        Vector2d newGrassPosition;

        do {
            int x = getRandomNumberInRange(this.minRangeOfGrassTufts, this.maxRangeOfGrassTufts);
            int y = getRandomNumberInRange(this.minRangeOfGrassTufts, this.maxRangeOfGrassTufts);
            newGrassPosition = new Vector2d(x, y);
        } while (this.isOccupied(newGrassPosition));

        this.mapElements.put(newGrassPosition, new Grass(newGrassPosition));

        //this.mapElements.put(newGrassPosition, new Grass(new Vector2d(2,2)));
        //^test, zmierzęta mają pierwszeństwo w byciu umieszczonym na mapie na starcie
    }

    public void eatGrass(Vector2d positionOfGrass) {
        this.mapElements.remove(positionOfGrass);
    }

    @Override
    public String toString() {
        for (AbstractWorldMapElement mapElement : this.mapElements.values()) {
            this.upperRightCorner = this.upperRightCorner.upperRight(mapElement.getPosition());
            this.lowerLeftCorner = this.lowerLeftCorner.lowerLeft(mapElement.getPosition());
        }

        return super.toString();
    }
}
