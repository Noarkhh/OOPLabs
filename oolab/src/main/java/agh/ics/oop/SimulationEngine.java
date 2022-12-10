package agh.ics.oop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements Runnable {
    private List<MoveDirection> directions = new LinkedList<>();
    private final LinkedList<Animal> animals = new LinkedList<>();
    private final int moveDelayMs = 300;

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] positions) {
        for (Vector2d position : positions) {
            Animal new_animal = new Animal(map, position);
            map.place(new_animal);
            animals.add(new_animal);
        }
        this.directions = directions;
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positions) {
        for (Vector2d position : positions) {
            Animal new_animal = new Animal(map, position);
            map.place(new_animal);
            animals.add(new_animal);
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        for (Animal animal : animals) animal.addObserver(observer);
    }

    public void setDirections(List<MoveDirection> directionList) {
        directions = directionList;
    }

    @Override
    public void run() {
        System.out.println("Running the simulation.");
        Iterator<Animal> it = animals.iterator();
        if (!it.hasNext()) return;

        for (MoveDirection direction : directions) {
            moveDelay();

            if (!it.hasNext()) {
                it = animals.listIterator();
            }
            it.next().move(direction);
        }
    }

    private void moveDelay() {
        try {
            Thread.sleep(moveDelayMs);
        } catch (InterruptedException e) {
            System.out.println("obudzono!");
        }
    }
}
