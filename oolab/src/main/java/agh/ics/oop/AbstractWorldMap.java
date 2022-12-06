package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap{
    protected final HashMap<Vector2d, AbstractMapElement> elements = new HashMap<>();
    protected final Vector2d lowerLeft;
    protected final Vector2d upperRight;

    AbstractWorldMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    AbstractWorldMap(Vector2d lowerLeft, Vector2d upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }
    @Override
    public boolean canMoveTo(Vector2d vec) {
        if (vec.x > upperRight.x) return false;
        if (vec.y > upperRight.y) return false;
        if (vec.x < lowerLeft.x) return false;
        if (vec.y < lowerLeft.y) return false;
        return !(elementAt(vec) instanceof Animal);
    }

    @Override
    public void place(AbstractMapElement newElement) {
        if (elements.get(newElement.getPosition()) != null) {
            throw new IllegalArgumentException("Position " + newElement.getPosition() + " already occupied!");
        }
        elements.put(newElement.getPosition(), newElement);
    }

    protected boolean remove(AbstractMapElement newElement) {
        return elements.remove(newElement.getPosition()) != null;
    }

    @Override
    public AbstractMapElement elementAt(Vector2d position) {
        return elements.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractMapElement movedElement = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, movedElement);
    }

    abstract Vector2d[] getDrawingBounds();

    @Override
    public String toString() {
        Vector2d[] drawingBounds = getDrawingBounds();
        return new MapVisualizer(this).draw(drawingBounds[0], drawingBounds[1]);
    }
}
