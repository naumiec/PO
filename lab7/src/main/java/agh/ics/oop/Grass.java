package agh.ics.oop;


public class Grass extends AbstractWorldMapElement implements IMapElement {
    public Grass(Vector2d position) {
        super(position);
    }

    @Override
    public String toString() {
        return "*";
    }
}
