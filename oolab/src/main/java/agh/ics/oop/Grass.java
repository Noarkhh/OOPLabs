package agh.ics.oop;

import agh.ics.oop.gui.SpriteContainer;
import javafx.scene.image.Image;

public class Grass extends AbstractMapElement {
    Grass(Vector2d position) {
        super(position);
    }

    @Override
    public Image getImage(SpriteContainer spriteContainer) {
        return spriteContainer.getSprite("grass");
    }

    @Override
    public String toString() {
        return "*";
    }
}
