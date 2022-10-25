package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalMovementTest {
    @Test
    public void test1() {
        Animal animal = new Animal(new Map(new Vector2d(0, 0), new Vector2d(4, 4)));
        for (MoveDirection moveDirection : OptionsParser.parse(new String[]{"r", "f", "f"})) {
            animal.move(moveDirection);
        }
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());
        Assertions.assertEquals(new Vector2d(4, 2), animal.getPosition());
    }

    @Test
    public void test2() {
        Animal animal = new Animal(new Map(new Vector2d(0, 0), new Vector2d(4, 4)));

        for (MoveDirection moveDirection : OptionsParser.parse(new String[]{"f", "f", "f", "f", "f"})) {
            animal.move(moveDirection);
        }
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
        Assertions.assertEquals(new Vector2d(2, 4), animal.getPosition());
    }

    @Test
    public void test3() {
        Animal animal = new Animal(new Map(new Vector2d(0, 0), new Vector2d(4, 4)));

        for (MoveDirection moveDirection : OptionsParser.parse(new String[]{"f", "r", "f", "r", "f", "r", "f", "r"})) {
            animal.move(moveDirection);
        }
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());
        Assertions.assertEquals(new Vector2d(2, 2), animal.getPosition());
    }

    @Test
    public void testParse() {
        Animal animal = new Animal(new Map(new Vector2d(0, 0), new Vector2d(4, 4)));
        for (MoveDirection moveDirection : OptionsParser.parse(new String[]{"r", "f", "gibon", "f", "szynszyla", "g"})) {
            animal.move(moveDirection);
        }
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());
        Assertions.assertEquals(new Vector2d(4, 2), animal.getPosition());
    }
}
