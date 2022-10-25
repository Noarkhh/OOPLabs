package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    private Map map;

    Animal(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return String.format("Position: %s\nOrientation: %s", position.toString(), orientation.toString());
    }

    public boolean isAt(Vector2d position_to_test) {
        return position.equals(position_to_test);
    }

    public void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD, BACKWARD -> {
                Vector2d new_position = position.add(orientation.toUnitVector());
                if (map.doesContain(new_position)) {
                    if (moveDirection.equals(MoveDirection.FORWARD)) {
                        position = position.add(orientation.toUnitVector());
                    } else {
                        position = position.subtract(orientation.toUnitVector());
                    }
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
