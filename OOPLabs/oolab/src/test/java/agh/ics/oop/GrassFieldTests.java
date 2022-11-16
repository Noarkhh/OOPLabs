package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTests {

    @Test
    public void test1() {
        GrassField grassField = new GrassField(40);
        grassField.place(new Animal(grassField, new Vector2d(5, 5)));

        Assertions.assertEquals(Animal.class, grassField.elementAt(new Vector2d(5, 5)).getClass());
        Assertions.assertFalse(grassField.place(new Animal(grassField, new Vector2d(5, 5))));
    }

    @Test
    public void test2() {
        GrassField grassField = new GrassField(1);
        Animal animal = new Animal(grassField, new Vector2d(5, 5));
        grassField.place(animal);
        grassField.place(new Grass(new Vector2d(6, 5)));

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);

        Assertions.assertNull(grassField.elementAt(new Vector2d(6, 5)));
    }
}
