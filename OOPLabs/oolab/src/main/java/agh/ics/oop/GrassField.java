package agh.ics.oop;

import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final int grassPatchesRange;

    GrassField(int initialGrassAmount) {
        super(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE), new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.grassPatchesRange = (int) Math.sqrt(initialGrassAmount * 10);
        Random random = new Random();
        int placedPatches = 0;
        while (placedPatches < initialGrassAmount) {
            Grass newPatch = new Grass(new Vector2d(random.nextInt(grassPatchesRange), random.nextInt(grassPatchesRange)));
            if (place(newPatch)) placedPatches++;
        }
    }

    public boolean replacePatchAt(Vector2d patchPosition) {

        if (remove(elementAt(patchPosition))) {
            Random random = new Random();
            while (true) {
                Vector2d newPosition = new Vector2d(random.nextInt(grassPatchesRange), random.nextInt(grassPatchesRange));
                if (newPosition != patchPosition && elementAt(newPosition) == null) {
                    place(new Grass(newPosition));
                    return true;
                }
            }
        } else return false;
    }

    @Override
    Vector2d[] getDrawingBounds() {
        if (elements.size() == 0) return new Vector2d[]{new Vector2d(0, 0), new Vector2d(10, 10)};

        Vector2d dynLowerLeft = upperRight;
        Vector2d dynUpperRight = lowerLeft;
        for (Map.Entry<Vector2d, AbstractMapElement> element : elements.entrySet()) {
            dynLowerLeft = dynLowerLeft.lowerLeft(element.getKey());
            dynUpperRight = dynUpperRight.upperRight(element.getKey());
        }
        return new Vector2d[]{dynLowerLeft, dynUpperRight};
    }
}
