package agh.ics.oop;

import java.util.Comparator;

public class VectorComparator implements Comparator<Vector2d> {

    private final int comparisonDimension;
    VectorComparator(int dimension) throws IllegalArgumentException {
        this.comparisonDimension = dimension;
        if (dimension != 0 && dimension != 1) throw new IllegalArgumentException("Bad dimension");
    }

    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        if (comparisonDimension == 0) {
            return o1.x - o2.x;
        }
        if (comparisonDimension == 1) {
            return o1.y - o2.y;
        }
        return 0;
    }
}
