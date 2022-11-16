package agh.ics.oop;

import java.util.LinkedList;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final LinkedList<Grass> grassPatches = new LinkedList<>();
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

    @Override
    public boolean place(AbstractMapElement newElement) {
        if (super.place(newElement)) {
            if (newElement instanceof Grass) grassPatches.add((Grass) newElement);
            return true;
        }
        return false;
    }

    public boolean replacePatchAt(Vector2d patchPosition) {

        if (remove(grassAt(patchPosition))) {
            Random random = new Random();
            while (true) {
                Vector2d newPosition = new Vector2d(random.nextInt(grassPatchesRange), random.nextInt(grassPatchesRange));
                if (elementAt(newPosition) == null) {
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
        for (AbstractMapElement element : elements) {
            dynLowerLeft = dynLowerLeft.lowerLeft(element.getPosition());
            dynUpperRight = dynUpperRight.upperRight(element.getPosition());
        }
        return new Vector2d[]{dynLowerLeft, dynUpperRight};
    }

    public Grass grassAt(Vector2d position) {
        for (Grass grassPatch : grassPatches) {
            if (grassPatch.position.equals(position)) return grassPatch;
        }
        return null;
    }
}
