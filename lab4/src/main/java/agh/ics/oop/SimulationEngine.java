package agh.ics.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SimulationEngine implements IEngine{
    private final IWorldMap map;
    private final List<Animal> animals;
    private final List<MoveDirection> directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, List<Vector2d> positions) {
        this.directions = Arrays.asList(directions);
        this.map = map;
        this.animals = placeAnimals(positions);
    }

    public List<Animal> placeAnimals(List<Vector2d> positions) {
        List<Animal> animalPositionslsList = new ArrayList<>();

        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map, position);

            if(this.map.place(animal)) {
                animalPositionslsList.add(animal);
            }
        }

        return animalPositionslsList;
    }

    public List<Animal> getAnimalsList() {
        return this.animals;
    }

    public List<Vector2d> getAnimalsPositionsList() {
        List<Vector2d> animalsPositionsList = new ArrayList<>();

        for (Animal animal : this.animals) {
            animalsPositionsList.add(animal.getPosition());
        }

        return animalsPositionsList;
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
}
