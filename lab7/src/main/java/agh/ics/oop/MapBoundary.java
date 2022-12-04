package agh.ics.oop;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2d> sortedMapVectorsX = new TreeSet<>(
            (v1, v2) -> v1.x == v2.x
                    ? v1.y - v2.y
                    : v1.x - v2.x
    );

    private final SortedSet<Vector2d> sortedMapVectorsY = new TreeSet<>(
            (v1, v2) -> v1.y == v2.y
                    ? v1.x - v2.x
                    : v1.y - v2.y
    );

    public void addVector(Vector2d vector) {
        this.sortedMapVectorsX.add(vector);
        this.sortedMapVectorsY.add(vector);
    }

    public void removeVector(Vector2d vector) {
        this.sortedMapVectorsX.remove(vector);
        this.sortedMapVectorsY.remove(vector);
    }

    public Vector2d getLowerLeftCorner() {
        if (this.sortedMapVectorsX.isEmpty() || this.sortedMapVectorsY.isEmpty()) {
            return new Vector2d(0, 0);
        } else {
            return new Vector2d(sortedMapVectorsX.first().x, sortedMapVectorsY.first().y);
        }
    }

    public Vector2d getUpperRightCorner() {
        if (sortedMapVectorsX.isEmpty() || sortedMapVectorsY.isEmpty()) {
            return new Vector2d(0, 0);
        } else {
            return new Vector2d(sortedMapVectorsX.last().x, sortedMapVectorsY.last().y);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeVector(oldPosition);
        addVector(newPosition);
    }

    /*
    private static class Compare {
        private static int comparatorX(Vector2d v1, Vector2d v2) {
            if (v1.x == v2.x) {
                return v1.y - v2.y;
            } else {
                return v1.x - v2.x;
            }
        }

        private static int comparatorY(Vector2d v1, Vector2d v2) {
            if (v1.y == v2.y) {
                return v1.x - v2.x;
            } else {
                return v1.y - v2.y;
            }
        }
    }
     */
}
