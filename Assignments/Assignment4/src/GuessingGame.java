
// You may use the nested comments below as hints only. Remember, there is no one right or wrong way
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;
import java.util.Scanner;

/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Fall 2025
 * TODO: REPLACE THIS CAPITALIZED TEXT WITH THE DESCRIPTION OF THIS CLASS <br>
 * TODO: REPLACE THIS CAPITALIZED TEXT WITH THE DESCRIPTION OF HOW TO WIN MOST
 * EFFICIENTLY <br>
 *
 * @author Daniel Song
 * @author Trevon Watson
 */
public class GuessingGame extends Object {
    // List any instance variables, including constants, here.
    private static final int MAX_POSSIBLE_GUESS = 64; // This is a constant
    private static final int MIN_POSSIBLE_GUESS = -64;
    // Use an array instance variable to hold the guesses
    public static final int MAX_GUESSES = 8;
    int guessesLeft = MAX_GUESSES;
    int[] inputGuess = new int[MAX_GUESSES];

    private final Random randomNumberGenerator = new Random();

    // If you need to get a number for the user to guess (randomly),
    // call the method below and it will create one for you.
    // The number may be as low as -64, and as high as 64
    // (This will be 129 separate numbers that the user might try to guess)
    // Of course, you will have to create a variable space to hold this number
    // when it is returned (for example, secretNumber)
    public int getRandomNumber()
    {
        int max = MAX_POSSIBLE_GUESS - MIN_POSSIBLE_GUESS;
        int zeroToMax = randomNumberGenerator.nextInt(max + 1);
        return zeroToMax + MIN_POSSIBLE_GUESS;
    }

    // You may want to create a method that will display the welcome message and
    // rules (e.g., welcome)
    public void welcome() {
        System.out.println("Welcome!");
        System.out.println("Rules:");
        System.out.println("1) You have 8 guesses");
        System.out.println("2) If you guess the wrong number, a hint will be displayed");
        System.out.println("3) Your guess has to be between -64 and 64");
    }

    // You may want to create a method (e.g., isGuessNum) that will check to see
    // that the number entered is a whole number,
    // assign it to a variable like userGuess, and then handle all
    // the various options regarding that number: has it been guessed before?; is it
    // the secret number?; if it isn't the secret number store it in the proper
    // location for cross checking; display messages regarding the number of guesses
    // made,
    // incorrect guesses, guesses remaining, secret number if all guesses used up,
    // error handling, etc.
    public boolean isGuessNum(int secretNumber) {
        int userGuess = this.getInput(MIN_POSSIBLE_GUESS, MAX_POSSIBLE_GUESS);

        if (this.isCorrectGuess(userGuess, secretNumber)) {
            return true;
        } else {
            if (this.hasBeenGuessed(userGuess)) {
                System.out.println("You have already guessed " + userGuess + ". Try again.");
            } else {
                this.saveGuess(userGuess);
                System.out.println(this.getHint(userGuess, secretNumber));
                this.printPreviousGuesses();
            }
            if (this.isGuessInRange(userGuess)) {
                System.out.println(userGuess + " is NOT a number in the valid range. Please enter a whole number between " + MIN_POSSIBLE_GUESS + " and " + MAX_POSSIBLE_GUESS + ":");
            }
            return false;
        }
    }

    // You may want to create a method to print the user's previous guesses
    public void printPreviousGuesses() {
        System.out.print("Previous guess(es):");
        for (int i = 0; i < MAX_GUESSES - guessesLeft; i++) {
            System.out.print(" " + inputGuess[i]);
            if (i < MAX_GUESSES - guessesLeft - 1) {
                System.out.print(",");
            }
        }
        System.out.println(".");
        System.out.println("You have " + guessesLeft + " guess(es) left.");
    }

    // You may want to create a method to store the user's guesses in the 8 elements
    // of the array
    public void saveGuess(int guess) {
        if (guessesLeft > 0) {
            inputGuess[MAX_GUESSES - guessesLeft] = guess;
            guessesLeft--;
        }
    }

    // You will NEED a getInput method for getting integer input from the user (see
    // the assignment instructions on applying the techniques of structured
    // (functional) decomposition)).
    /**
     * Checks so the input is valid (an int between min & max).
     *
     * @param min
     * @param max
     * @return valid int the user entered via the keyboard
     */
    @SuppressWarnings("resource")
    public int getInput(int min, int max)
    {
        // TODO: Complete this method by using the assignment's instructions
        // Do NOT use recursion for this assignment.

        Scanner keyboard = new Scanner(System.in);
        while (true) { 
            if (keyboard.hasNextInt()) {
                int userInput = keyboard.nextInt();
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    System.out.println(userInput + " is NOT a number in the valid range. Please enter a whole number between " + min + " and " + max + ":");
                }
            } else {
                String invalidInput = keyboard.next();
                System.out.println(invalidInput + " is NOT a whole number. Please enter a whole number:");
            }
        }
    }

    // You may want to create a boolean method to check that the user's guess is
    // within range (between a minimum and maximum)
    // and will return true if it is
    private boolean isGuessInRange(int guess) {
        return (guess >= MIN_POSSIBLE_GUESS && guess <= MAX_POSSIBLE_GUESS);
    }

    // You may want to create a boolean method to see if the number has been guessed
    // previously and will return true if it has
    private boolean hasBeenGuessed(int guess) {
        for (int i = 0; i < MAX_GUESSES - guessesLeft; i++) {
            if (inputGuess[i] == guess) {
                return true;
            }
        }
        return false;
    }

    // You may want to create a boolean method to see if the number matches the
    // secret number and will return true if it does or false if it doesn't
    private boolean isCorrectGuess(int guess, int secretNumber) {
        return (guess == secretNumber);
    }

    // You may want to create a method to give a hint about the number guessed
    // (e.g., "My secret number is GREATER than " or "My secret number is LESS than
    // ")
    private String getHint(int guess, int secretNumber) {
        if (guess < secretNumber) {
            return "My secret number is GREATER than " + guess + ".";
        } else {
            return "My secret number is LESS than " + guess + ".";
        }
    }

    // You may want to create a method (e.g., playGame) that will check if the user
    // wants to play again, by calling the method for getting integer input from the
    // user,
    // (1 for 'yes', 0 for 'no') and incorporate the proper functionality depending
    // on the user's choice ( 1 or 0).
    private int playGame() {
        System.out.println("Do you want to play again? Enter 1 for 'yes' or 0 for 'no':");
        int choice = this.getInput(0, 1);
        return choice;
    }

    public void playGuessingGame()
    {
        int secretNumber = this.getRandomNumber(); // Feel free to move this into another method

        this.welcome(); // You might call a welcome() method here instead

        // You might create a loop here that will check numberGuesses 8 times and print
        // the guess number and call the
        // pertinent method (e.g., isGuessNum)
        while (guessesLeft > 0) {
            System.out.println("Enter a whole number between " + MIN_POSSIBLE_GUESS + " and " + MAX_POSSIBLE_GUESS + ":");
            if (this.isGuessNum(secretNumber)) {
                System.out.println("You won!");
                return;
            }
            // System.out.println("You have " + guessesLeft + " guesses left.");
        }

        // You might call and capture results from method (e.g., playGame) to see if
        // user wants to play again and if
        // so return it. Example: int playAgain = this.playGame();

        return; // if you want to end the game early & go directly back to main,
                // you can use a "return;" statement like this one (e.g., return playAgain;)
    }

}
