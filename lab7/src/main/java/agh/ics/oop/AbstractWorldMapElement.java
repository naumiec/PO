package agh.ics.oop;


public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position = new Vector2d(0, 0);

    protected AbstractWorldMapElement(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    /*
    public void setPosition(Vector2d position) {
        this.position = position;
    }
    */
}
