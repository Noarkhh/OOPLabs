package agh.ics.oop.gui;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SpriteContainer {
    private final Map<String, Image> spriteMap = new HashMap<>();

    public SpriteContainer(List<String> spritesToLoadNames) throws NullPointerException {
        for (String spriteName : spritesToLoadNames) {
            spriteMap.put(spriteName, new Image(Objects.requireNonNull(Image.class.getClassLoader().getResourceAsStream(spriteName + ".png"))));
        }
    }

    public Image getSprite(String spriteName) {
        return spriteMap.get(spriteName);
    }
}
