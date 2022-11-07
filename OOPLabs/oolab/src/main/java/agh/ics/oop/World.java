package agh.ics.oop;
import java.util.Arrays;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        String[] args1 = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args1);
        out.println(Arrays.toString(directions));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        out.println(map);
        engine.run();
        out.println(map);
    }
}
