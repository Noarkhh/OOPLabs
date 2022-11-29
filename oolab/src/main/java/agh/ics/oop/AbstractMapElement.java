package agh.ics.oop;

public abstract class AbstractMapElement {
    protected Vector2d position;
    protected Vector2d previousPosition;
    protected AbstractMapElement(Vector2d position) {
        this.position = position;
        this.previousPosition = position;
    }

    Vector2d getPosition() {
        return position;
    }
    
}
