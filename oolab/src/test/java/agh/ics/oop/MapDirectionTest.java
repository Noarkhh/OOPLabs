package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void testNext() {
        MapDirection mapDirection1 = MapDirection.NORTH;
        MapDirection mapDirection2 = MapDirection.EAST;
        MapDirection mapDirection3 = MapDirection.SOUTH;
        MapDirection mapDirection4 = MapDirection.WEST;
        Assertions.assertEquals(MapDirection.EAST, mapDirection1.next());
        Assertions.assertEquals(MapDirection.SOUTH, mapDirection2.next());
        Assertions.assertEquals(MapDirection.WEST, mapDirection3.next());
        Assertions.assertEquals(MapDirection.NORTH, mapDirection4.next());
    }

    @Test
    public void testPrevious() {
        MapDirection mapDirection1 = MapDirection.NORTH;
        MapDirection mapDirection2 = MapDirection.EAST;
        MapDirection mapDirection3 = MapDirection.SOUTH;
        MapDirection mapDirection4 = MapDirection.WEST;
        Assertions.assertEquals(MapDirection.WEST, mapDirection1.previous());
        Assertions.assertEquals(MapDirection.NORTH, mapDirection2.previous());
        Assertions.assertEquals(MapDirection.EAST, mapDirection3.previous());
        Assertions.assertEquals(MapDirection.SOUTH, mapDirection4.previous());
    }
}
