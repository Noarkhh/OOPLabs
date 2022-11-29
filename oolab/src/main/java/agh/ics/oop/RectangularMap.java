package agh.ics.oop;

import java.util.LinkedList;

public class RectangularMap extends AbstractWorldMap {

    RectangularMap(int width, int height) {
        super(width, height);
    }

    RectangularMap(Vector2d lowerLeft, Vector2d upperRight) {
        super(lowerLeft, upperRight);
    }

    @Override
    Vector2d[] getDrawingBounds() {
        return new Vector2d[]{lowerLeft, upperRight};
    }
}
