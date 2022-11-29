package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] characters) {
        MoveDirection[] moveDirections = new MoveDirection[characters.length];
        int dir_ind = 0;
        for (String character : characters) {
            MoveDirection moveDirection = switch (character) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> MoveDirection.INVALID;
            };
            if (moveDirection != MoveDirection.INVALID) {
                moveDirections[dir_ind] = moveDirection;
                dir_ind++;
            }
        }
        return Arrays.copyOfRange(moveDirections, 0, dir_ind);
    }
}
