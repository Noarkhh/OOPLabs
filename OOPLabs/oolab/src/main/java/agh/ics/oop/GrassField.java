package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private

    GrassField(int grassPatches) {
        super(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE), new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Random random = new Random();
        int placedPatches = 0;
        while (placedPatches < grassPatches) {

        }
    }

    @Override
    Vector2d[] getDrawingBounds() {
        return new Vector2d[]{lowerLeft, upperRight};
    }
}
