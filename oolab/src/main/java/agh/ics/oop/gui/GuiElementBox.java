package agh.ics.oop.gui;

import agh.ics.oop.AbstractMapElement;
import agh.ics.oop.Animal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    private final VBox vBox;

    public GuiElementBox(AbstractMapElement element, SpriteContainer spriteContainer) {
        ImageView elementImageView = new ImageView(element.getImage(spriteContainer));
        elementImageView.setFitHeight(20);
        elementImageView.setFitWidth(20);
        if (element instanceof Animal) {
            vBox = new VBox(elementImageView, new Label(element.getPosition().toString()));
        } else {
            vBox = new VBox(elementImageView);
        }
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getBox() { return vBox; }
}
