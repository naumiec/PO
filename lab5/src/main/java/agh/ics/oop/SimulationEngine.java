package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SimulationEngine implements IEngine {
    private final AbstractWorldMap map;
    private final List<Animal> animals;
    private final List<MoveDirection> directions;

    public SimulationEngine(List<MoveDirection> directions, AbstractWorldMap map, List<Vector2d> positions) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();

        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map, position);

            if(this.map.place(animal)) {
                this.animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        int numberOfAnimals = this.animals.size();
        System.out.println("Liczba zwierząt: " + numberOfAnimals);
        System.out.println(this.map);

        for(int i = 0; i < directions.size(); i++) {
            int animalIndex = i % numberOfAnimals;
            animals.get(animalIndex).move(directions.get(i));
            System.out.println(this.map);
        }
    }

    // do testowania rozwiązań
    public List<Vector2d> getAnimalsPositions() {
        List<Vector2d> positions = new ArrayList<>();

        for (Animal animal : this.animals)
            positions.add(animal.getPosition());

        return positions;
    }
}
