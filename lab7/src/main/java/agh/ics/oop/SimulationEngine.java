package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final AbstractWorldMap map;
    private final ArrayList<Animal> animalsList = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;

        for (Vector2d position : initialPositions) {
            spawnAnimal(position);
        }
    }

    private void spawnAnimal(Vector2d position) {
        Animal newAnimal = new Animal(map, position);
        animalsList.add(newAnimal);
        map.place(newAnimal);
    }

    @Override
    public void run() {
        int numberOfAnimals = this.animalsList.size();

        System.out.println("Liczba zwierząt: " + numberOfAnimals);
        System.out.println(this.map);

        for (int i = 0; i < moves.length; i++) {
            int animalIndex = i % numberOfAnimals;

            animalsList.get(animalIndex).move(moves[i]);

            System.out.println(this.map);
            System.out.println("Pozycja zwierzęcia nr " + (animalIndex + 1) + ": " + animalsList.get(animalIndex).getPosition());
        }
    }

    // for testing purposes only - returns list of animals' positions to compare results
    public List<Vector2d> getAnimalsPositions() {
        List<Vector2d> positions = new ArrayList<>();

        for (Animal animal : this.animalsList)
            positions.add(animal.getPosition());

        return positions;
    }
}
