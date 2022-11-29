package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void testEquals() {
        Vector2d v1 = new Vector2d(1, 4);
        Vector2d v2 = new Vector2d(1, 4);
        Vector2d v3 = new Vector2d(4, 5);
        Assertions.assertEquals(v1, v2);
        Assertions.assertNotEquals(v1, v3);
    }

    @Test
    public void testToString() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(-2, -5);
        Assertions.assertEquals("(2,6)", v1.toString());
        Assertions.assertEquals("(-2,-5)", v2.toString());
    }

    @Test
    public void testPrecedes() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(3, 8);
        Vector2d v3 = new Vector2d(4, 7);
        Assertions.assertTrue(v1.precedes(v2));
        Assertions.assertFalse(v2.precedes(v3));
        Assertions.assertTrue(v1.precedes(v1));
    }

    @Test
    public void testFollows() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(3, 8);
        Vector2d v3 = new Vector2d(4, 7);
        Assertions.assertTrue(v2.follows(v1));
        Assertions.assertFalse(v3.follows(v2));
        Assertions.assertTrue(v1.follows(v1));
    }

    @Test
    public void testUpperRight() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(-1, 8);
        Vector2d v3 = new Vector2d(-5, 2);
        Assertions.assertEquals(new Vector2d(2, 8), v1.upperRight(v2));
        Assertions.assertEquals(new Vector2d(-1, 8), v2.upperRight(v3));
        Assertions.assertEquals(v2, v2.upperRight(v2));

    }

    @Test
    public void testLowerLeft() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(-1, 8);
        Vector2d v3 = new Vector2d(-5, 2);
        Assertions.assertEquals(new Vector2d(-1, 6), v1.lowerLeft(v2));
        Assertions.assertEquals(new Vector2d(-5, 2), v2.lowerLeft(v3));
        Assertions.assertEquals(v2, v2.lowerLeft(v2));
    }

    @Test
    public void testAdd() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(-1, 8);
        Vector2d v3 = new Vector2d(-5, 2);
        Assertions.assertEquals(new Vector2d(1, 14), v1.add(v2));
        Assertions.assertEquals(new Vector2d(-6, 10), v2.add(v3));
    }

    @Test
    public void testSubtract() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(-1, 8);
        Vector2d v3 = new Vector2d(-5, 2);
        Assertions.assertEquals(new Vector2d(3, -2), v1.subtract(v2));
        Assertions.assertEquals(new Vector2d(4, 6), v2.subtract(v3));
    }

    @Test
    public void testOpposite() {
        Vector2d v1 = new Vector2d(2, 6);
        Vector2d v2 = new Vector2d(-1, 8);
        Vector2d v3 = new Vector2d(-5, 2);
        Assertions.assertEquals(new Vector2d(-2, -6), v1.opposite());
        Assertions.assertEquals(new Vector2d(1, -8), v2.opposite());
        Assertions.assertEquals(new Vector2d(5, -2), v3.opposite());
    }
}
