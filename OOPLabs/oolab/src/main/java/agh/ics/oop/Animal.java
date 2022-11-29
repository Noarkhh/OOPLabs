package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal extends AbstractMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map = new RectangularMap(5, 5);
    private final List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.map = map;
        observers.add(map);
        eatGrass();
    }

    public Animal() {
        super(new Vector2d(2, 2));
    }
    @Override
    public String toString() {
        return orientation.toString();
    }

    public boolean isAt(Vector2d position_to_test) {
        return position.equals(position_to_test);
    }

    public void move(MoveDirection moveDirection) {
        previousPosition = position;
        switch (moveDirection) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d new_position = position.add(orientation.toUnitVector());
                if (map.canMoveTo(new_position)) position = new_position;

            }
            case BACKWARD -> {
                Vector2d new_position = position.subtract(orientation.toUnitVector());
                if (map.canMoveTo(new_position)) position = new_position;
            }

        }
        eatGrass();
        positionChanged();
        System.out.println(previousPosition);
        System.out.println(position);
        System.out.println("\n");
    }

    public boolean eatGrass() {
        if (map instanceof GrassField grassField && grassField.elementAt(position) instanceof Grass) {
            grassField.replacePatchAt(position);
            return true;
        }
        return false;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    private void positionChanged() {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(previousPosition, position);
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
}
