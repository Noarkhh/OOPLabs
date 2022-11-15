package agh.ics.oop;

import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap{
    protected final LinkedList<Animal> animals = new LinkedList<>();
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
        return !isOccupied(vec);
    }

    @Override
    public boolean place(Animal animal) {
        for (Animal present_animal : animals) {
            if (present_animal.getPosition().equals(animal.getPosition())) return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal present_animal : animals) {
            if (present_animal.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal present_animal : animals) {
            if (present_animal.getPosition().equals(position)) return present_animal;
        }
        return null;
    }

    abstract Vector2d[] getDrawingBounds();

    public String toString() {
        Vector2d[] drawingBounds = getDrawingBounds();
        return new MapVisualizer(this).draw(drawingBounds[0], drawingBounds[1]);
    }
}
