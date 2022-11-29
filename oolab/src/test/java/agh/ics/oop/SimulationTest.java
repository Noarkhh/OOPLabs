package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationTest {
    @Test
    public void testSimulation() {
        String[] args1 = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args1);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertTrue(map.elementAt(new Vector2d(3, 4)) instanceof Animal);
        Animal animal = (Animal) map.elementAt(new Vector2d(3, 4));
        Assertions.assertEquals(MapDirection.NORTH, animal.getOrientation());

        Assertions.assertTrue(map.elementAt(new Vector2d(2, 0)) instanceof Animal);
        animal = (Animal) map.elementAt(new Vector2d(2, 0));
        Assertions.assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }

    @Test
    public void testSimulation2() {
        String[] args1 = new String[]{"f", "f", "f", "l", "f", "r", "r", "f", "l", "b", "b", "r"};
        MoveDirection[] directions = OptionsParser.parse(args1);
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(0, 0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertTrue(map.elementAt(new Vector2d(1, 1)) instanceof Animal);
        Animal animal = (Animal) map.elementAt(new Vector2d(1, 1));
        Assertions.assertEquals(MapDirection.EAST, animal.getOrientation());
    }
}
