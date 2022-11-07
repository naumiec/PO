package agh.ics.oop;

import java.util.Arrays;


public class World {
    public static void main(String[] args) {
        System.out.print("---START---\n");

        Animal animal = new Animal();
        System.out.println(animal.toString() + "\n");

        //test działania poruszania się zwierzęcia
        /*MoveDirection[] commands = new MoveDirection[4];
        commands[0] = MoveDirection.RIGHT;
        commands[1] = MoveDirection.FORWARD;
        commands[2] = MoveDirection.FORWARD;
        commands[3] = MoveDirection.FORWARD;

        animal.move(commands);

        if (animal.isAt(new Vector2d(4, 2))) {
            System.out.println("Pozycja OK");
        }

        if (animal.getOrientation() == MapDirection.EAST) {
            System.out.println("Orientacja OK");
        }*/

        OptionsParser parser = new OptionsParser();

        String[] commands = {"f", "f", "f", "f", "r", "f"};
        MoveDirection[] directions = parser.parse(commands);
        //MoveDirection[] directions = parser.parse(args);

        System.out.print("Kierunki:" + Arrays.toString(directions));
        animal.move(directions);

        //wyświetlanie rezultatu
        System.out.println("\n" + animal.toString());

        System.out.print("---STOP---\n");
    }
}