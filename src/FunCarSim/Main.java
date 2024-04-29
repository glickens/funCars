package FunCarSim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarDescription myCarDescription = new CarDescription();
        CarActions carActions = new CarActions();
        Scanner scanner = new Scanner(System.in);

        myCarDescription.color = "Red";
        myCarDescription.doors = 2;
        myCarDescription.make = "Toyota";
        myCarDescription.model = "Corolla";

        System.out.println("|Option(4)------Corolla---------|");
        System.out.println("Color: " + myCarDescription.color);
        System.out.println("Number of Doors: " + myCarDescription.doors);
        System.out.println("Make: " + myCarDescription.make);
        System.out.println("Model: " + myCarDescription.model);
        System.out.println("Gas tank Full?: " + (myCarDescription.isEmpty = true));
        System.out.println();

        CarDescription muscleCarDescription = new CarDescription();
        muscleCarDescription.color = "Green";
        muscleCarDescription.doors = 4;
        muscleCarDescription.make = "Ford";
        muscleCarDescription.model = "Mustang";

        System.out.println("|Option(5)-------Mustang--------|");
        System.out.println("Color: " + muscleCarDescription.color);
        System.out.println("Number of Doors: " + muscleCarDescription.doors);
        System.out.println("Make: " + muscleCarDescription.make);
        System.out.println("Model: " + muscleCarDescription.model);
        System.out.println("Gas tank full?: " + (myCarDescription.isEmpty = false));
        System.out.println();

        System.out.print("Choose your car: 4 = Corolla, 5 = Mustang: ");
        int option1 = scanner.nextInt();

        // Play door opening and closing sound
        carActions.playSound("door_open_close.wav");

        if (option1 == 4) {
            System.out.println("**You chose the " + myCarDescription.model);
        } else if (option1 == 5) {
            System.out.println("**You chose the " + muscleCarDescription.model);
        }

        System.out.print("Do you need gas??: [y = yes, n = no] ");
        String needGas = scanner.next();
        if (needGas.equals("y")) {
            System.out.println("The car is being filled with gas.");
            carActions.fillGas(); // Play the gas filling sound
        } else if (needGas.equals("n")) {
            System.out.println("You already have a full tank of gas.");
        } else {
            do {
                System.out.println("You need to choose letters (y) or (n)\n");
                System.out.print("Do you need gas??: [y = yes, n = no] ");
                needGas = scanner.next(); // Update the value of needGas
            } while (!needGas.equals("y") && !needGas.equals("n"));
        }

        boolean carRunning = true;
        while (carRunning) {
            System.out.println("You are in the car, choose option: 1 = drive, 2 = brake, 3 = horn, 4 = stop");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    carActions.pressGas();
                    break;
                case 2:
                    carActions.pressBrakes();
                    break;
                case 3:
                    carActions.carHorn();
                    break;
                case 4:
                    System.out.println("Stopping the car...");
                    carRunning = false; // Exit the loop
                    break;
                case 5:
                    System.out.println("Turning off the car...");
                    carActions.crankUp();
                    break;
                default:
                    System.out.println("You made the wrong selection..");
            }
        }
    }
}
