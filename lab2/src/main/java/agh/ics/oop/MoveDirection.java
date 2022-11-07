package agh.ics.oop;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT,
    UNKNOWN;

    @Override
    public String toString(){
        return switch(this) {
            case FORWARD -> "do przodu";
            case BACKWARD -> "do tyłu";
            case RIGHT -> "w prawo";
            case LEFT -> "w lewo";
            case UNKNOWN -> "nieznany kierunek";
        };
    }
}
