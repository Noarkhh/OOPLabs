package agh.ics.oop;
import java.util.Arrays;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal(new Map(new Vector2d(0, 0), new Vector2d(4, 4)));
        out.println(animal);
        for (MoveDirection moveDirection : OptionsParser.parse(new String[]{"r", "f", "f"})) {
            animal.move(moveDirection);
        }
        out.println(animal);
        // A way to ensure that no two animals occupy the same place is to keep track of all animal positions and
        // every time an animal moves check if its destination is occupied. A good way to store this all information
        // would be in my Map class, either by keeping a list or dict of all animals, or a 2d array representing the
        // map and the animals on it in appropriate coordinates.
    }
    public static void run(Direction[] directions) {
        for (Direction direction : directions) {
            String message = switch (direction) {
                case FORWARD -> "idzie do przodu";
                case BACKWARD -> "idzie do tyłu";
                case RIGHT -> "skręca w prawo";
                case LEFT -> "skręca w lewo";
                default -> "";
            };
            if (!message.equals("")) out.println("Zwierzak " + message);
        }

    }
}
