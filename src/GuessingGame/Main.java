package GuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String greet = "Hello.";
        System.out.print("Guess a number between 1 and 10: ");
        int number = 0;
        int attempts = 0;

        do {
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Enter numbers only. ");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            attempts++;

            if (number != 6) {
                int remainingAttempts = 3 - attempts;
                if (remainingAttempts > 0) {
                    System.out.println("You have " + remainingAttempts + " attempts left.");
                    System.out.print("Wrong guess. Try again: ");
                } else {
                    System.out.println("You have tried 3 times, game over.");
                    return;
                }
            }
        } while (number != 6);

        System.out.print("You have guessed the right number: " + number);
    }
}
