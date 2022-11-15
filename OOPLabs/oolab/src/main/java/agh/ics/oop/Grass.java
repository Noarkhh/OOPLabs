package agh.ics.oop;

public class Grass extends AbstractMapElement {
    Grass(Vector2d position) {
        super(position);
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
