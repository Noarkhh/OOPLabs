package agh.ics.oop;
import java.util.Arrays;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
//        String[] chars = {"f", "f", "r"};
//        Direction[] directions = convert(chars);
//        run(directions);
        MapDirection mapDirection = MapDirection.WEST;
        out.println(mapDirection.toUnitVector());
        out.println("Stop");
    }
    public static Direction[] convert(String[] characters) {
        Direction[] directions = new Direction[characters.length];
        int dir_ind = 0;
        for (String character : characters) {
            Direction direction = switch (character) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.INVALID;
            };
            if (direction != Direction.INVALID) {
                directions[dir_ind] = direction;
                dir_ind++;
            }
        }
        return Arrays.copyOfRange(directions, 0, dir_ind);
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
