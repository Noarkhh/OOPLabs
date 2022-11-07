package agh.ics.oop;
import java.util.Arrays;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        String[] args1 = new String[]{"f", "f", "f", "l", "f", "r", "r", "f", "l", "b", "b", "r"};
        MoveDirection[] directions = OptionsParser.parse(args1);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0, 0) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        out.println(map);
        engine.run();
        out.println(map);
    }
}
