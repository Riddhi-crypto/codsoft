import java.util.Random;
import java.util.Scanner;
class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number  Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 5;
            boolean hasWon = false;

            System.out.println("\nI have generated a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scn.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasWon = true;
                    totalScore++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again. Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Too high! Try again. Attempts left: " + attemptsLeft);
                }
            }

            if (!hasWon) {
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scn.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score: " + totalScore);
        scn.close();
    }
}
