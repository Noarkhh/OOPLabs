package agh.ics.oop;

public class Map {
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    Map(Vector2d lowerLeft, Vector2d upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }
    public boolean doesContain(Vector2d vec) {
        if (vec.x > upperRight.x) return false;
        if (vec.y > upperRight.y) return false;
        if (vec.x < lowerLeft.x) return false;
        if (vec.y < lowerLeft.y) return false;
        return true;
    }
}
