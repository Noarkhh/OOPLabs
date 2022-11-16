package agh.ics.oop;

import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap{
    protected final LinkedList<Animal> animals = new LinkedList<>();
    protected final LinkedList<AbstractMapElement> elements = new LinkedList<>();
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
        return !isOccupiedByAnimal(vec);
    }

    @Override
    public boolean place(AbstractMapElement newElement) {
        AbstractMapElement existingElement = elementAt(newElement.getPosition());

        if (existingElement != null && existingElement.getClass().isInstance(newElement)) {
            return false;
        }
        elements.add(newElement);
        if (newElement instanceof Animal) animals.add((Animal) newElement);
        return true;
    }

    protected boolean remove(AbstractMapElement newElement) {
        return elements.remove(newElement);
    }

    @Override
    public boolean isOccupiedByAnimal(Vector2d position) {
        for (Animal present_animal : animals) {
            if (present_animal.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public AbstractMapElement elementAt(Vector2d position) {
        for (AbstractMapElement currentElement : elements) {
            if (currentElement.getPosition().equals(position)) return currentElement;
        }
        return null;
    }

    abstract Vector2d[] getDrawingBounds();

    @Override
    public String toString() {
        Vector2d[] drawingBounds = getDrawingBounds();
        return new MapVisualizer(this).draw(drawingBounds[0], drawingBounds[1]);
    }
}
