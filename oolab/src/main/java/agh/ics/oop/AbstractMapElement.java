package agh.ics.oop;

import agh.ics.oop.gui.SpriteContainer;
import javafx.scene.image.Image;

public abstract class AbstractMapElement {
    protected Vector2d position;
    protected Vector2d previousPosition;

    protected AbstractMapElement(Vector2d position) {
        this.position = position;
        this.previousPosition = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    abstract public Image getImage(SpriteContainer spriteContainer);
    
}
