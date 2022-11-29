package agh.ics.oop;

import java.util.Iterator;
import java.util.LinkedList;

public class SimulationEngine implements IEngine {
    MoveDirection[] directions;
    LinkedList<Animal> animals = new LinkedList<>();
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        for (Vector2d position : positions) {
            Animal new_animal = new Animal(map, position);
            if (map.place(new_animal)) {
                animals.add(new_animal);
            }
        }
        this.directions = directions;
    }

    @Override
    public void run() {
        Iterator<Animal> it = animals.iterator();
        if (!it.hasNext()) return;

        for (MoveDirection direction : directions) {
            if (!it.hasNext()) {
                it = animals.listIterator();
            }
            it.next().move(direction);
        }
    }
}
