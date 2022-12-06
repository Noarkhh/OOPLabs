package agh.ics.oop;

import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class MapBoundary implements IPositionChangeObserver {

    private final SortedSet<Vector2d> xPositions = new ConcurrentSkipListSet<>(new VectorComparator(0));
    private final SortedSet<Vector2d> yPositions = new ConcurrentSkipListSet<>(new VectorComparator(1));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xPositions.remove(oldPosition);
        yPositions.remove(oldPosition);

        xPositions.add(newPosition);
        yPositions.add(newPosition);
    }

    public void addElement(AbstractMapElement newElement) {
        xPositions.add(newElement.getPosition());
        yPositions.add(newElement.getPosition());
    }

    public Vector2d getUpperRight() {
        return new Vector2d(xPositions.last().x, yPositions.last().y);
    }

    public Vector2d getLowerLeft() {
        return new Vector2d(xPositions.first().x, yPositions.first().y);
    }
}
