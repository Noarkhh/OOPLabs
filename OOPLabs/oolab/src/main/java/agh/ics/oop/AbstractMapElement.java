package agh.ics.oop;

public abstract class AbstractMapElement {
    protected Vector2d position;
    protected AbstractMapElement(Vector2d position) {
        this.position = position;
    }

    Vector2d getPosition() {
        return position;
    }
    
}
