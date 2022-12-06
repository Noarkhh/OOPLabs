package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final int grassPatchesRange;
    public final MapBoundary mapBoundary = new MapBoundary();

    GrassField(int initialGrassAmount) {
        super(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE), new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.grassPatchesRange = (int) Math.sqrt(initialGrassAmount * 10);
        Random random = new Random();
        int placedPatches = 0;
        while (placedPatches < initialGrassAmount) {
            Vector2d newPatchPosition = new Vector2d(random.nextInt(grassPatchesRange), random.nextInt(grassPatchesRange));
            if (elementAt(newPatchPosition) == null) {
                place(new Grass(newPatchPosition));
                placedPatches++;
            }
        }
    }

    public void replacePatchAt(Vector2d patchPosition) {

        if (remove(elementAt(patchPosition))) {
            Random random = new Random();
            while (true) {
                Vector2d newPosition = new Vector2d(random.nextInt(grassPatchesRange), random.nextInt(grassPatchesRange));
                if (!newPosition.equals(patchPosition) && elementAt(newPosition) == null) {
                    place(new Grass(newPosition));
                    return;
                }
            }
        }
    }

    @Override
    Vector2d[] getDrawingBounds() {
        if (elements.size() == 0) return new Vector2d[]{new Vector2d(0, 0), new Vector2d(10, 10)};
        System.out.println(mapBoundary.getLowerLeft());
        System.out.println(mapBoundary.getUpperRight());
        return new Vector2d[]{mapBoundary.getLowerLeft(), mapBoundary.getUpperRight()};
    }

    @Override
    public void place(AbstractMapElement newElement) {
        super.place(newElement);
        mapBoundary.addElement(newElement);
    }
}
