package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(List<String> characters) throws IllegalArgumentException {
        List<MoveDirection> moveDirections = new LinkedList<>();
        for (String character : characters) {
            MoveDirection moveDirection = switch (character) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> MoveDirection.INVALID;
            };
            if (moveDirection == MoveDirection.INVALID) {
                throw new IllegalArgumentException(character + " is not legal move specification");
            }
            moveDirections.add(moveDirection);
        }
        return moveDirections;
    }

    public static List<MoveDirection> parse(String characters) throws IllegalArgumentException {
        return parse(List.of(characters.trim().split(" ")));
    }
}
