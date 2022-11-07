package agh.ics.oop;

import java.util.LinkedList;

public class RectangularMap implements IWorldMap {
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final LinkedList<Animal> animals = new LinkedList<>();

    RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    RectangularMap(Vector2d lowerLeft, Vector2d upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }
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

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }
}
