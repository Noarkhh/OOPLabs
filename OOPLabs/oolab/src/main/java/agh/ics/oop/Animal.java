package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map = new RectangularMap(5, 5);

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Animal() {}
    @Override
    public String toString() {
        return orientation.toString();
    }

    public boolean isAt(Vector2d position_to_test) {
        return position.equals(position_to_test);
    }

    public void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d new_position = position.add(orientation.toUnitVector());
                if (map.canMoveTo(new_position)) {
                    position = position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                Vector2d new_position = position.subtract(orientation.toUnitVector());
                if (map.canMoveTo(new_position)) {
                    position = position.subtract(orientation.toUnitVector());
                }
            }

        }
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }
}
