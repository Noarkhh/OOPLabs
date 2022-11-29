package agh.ics.oop;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 *
 */
public interface IWorldMap extends IPositionChangeObserver {
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    boolean canMoveTo(Vector2d position);

    /**
     * Place an element on the map.
     *
     * @param element
     *            The element to place on the map.
     * @return True if the element was placed. The element cannot be placed if the map is already occupied by an object
     * of the same instance.
     */
    boolean place(AbstractMapElement element);


    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    AbstractMapElement elementAt(Vector2d position);

}
