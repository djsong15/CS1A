
// You may use the nested comments below as hints only. Remember, there is no one right or wrong way
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;
import java.util.Scanner;

/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Fall 2025 <br>
 * F25 CS F001A 02W OBJ-ORIENTED PROG METHOD JAVA<br>
 * Start with the midpoint between the minimum and maximum possible guesses.
 * If the guess is incorrect, eliminate half of the possibilities based on
 * whether the guess
 * is too high or too low. Repeat this process until the number is guessed or
 * all guesses are used up.
 * In other words, perform a binary search algorithm.<br>
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
    boolean isPlaying = false;

    private final Random randomNumberGenerator = new Random();

    // If you need to get a number for the user to guess (randomly),
    // call the method below and it will create one for you.
    // The number may be as low as -64, and as high as 64
    // (This will be 129 separate numbers that the user might try to guess)
    // Of course, you will have to create a variable space to hold this number
    // when it is returned (for example, secretNumber)

    /**
     * @return A randomly generated integer between min and max
     */
    public int getRandomNumber() {
        int max = MAX_POSSIBLE_GUESS - MIN_POSSIBLE_GUESS;
        int zeroToMax = randomNumberGenerator.nextInt(max + 1);
        return zeroToMax + MIN_POSSIBLE_GUESS;
    }

    // You may want to create a method that will display the welcome message and
    // rules (e.g., welcome)

    /**
     * Prints the welcome message, including rules of the game.
     */
    public void welcome() {
        System.out.println("Welcome!");
        System.out.println("Rules:");
        System.out.println("1) You have " + MAX_GUESSES + " guesses");
        System.out.println("2) If you guess the wrong number, a hint will be displayed");
        System.out
                .println("3) Your guess has to be between " + MIN_POSSIBLE_GUESS + " and " + MAX_POSSIBLE_GUESS + ".");
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

    private void nextGuess(int userGuess, int secretNumber) {
        System.out.println(this.getHint(userGuess, secretNumber));
        System.out.println();
        this.printPreviousGuesses();
    }

    /**
     * Returns true if the user guessed the number and false otherwise.
     * 
     * @param secretNumber The randomly generated number the user
     *                     is to guess
     * @return Whether or not user guessed the secretNumber
     */
    public boolean isGuessNum(int secretNumber) {
        int userGuess = this.getInput(MIN_POSSIBLE_GUESS, MAX_POSSIBLE_GUESS);

        if (this.isCorrectGuess(userGuess, secretNumber)) {
            return true;
        } else {
            if (this.hasBeenGuessed(userGuess)) {
                System.out.println("You have already guessed " + userGuess + ". Try again.");
                nextGuess(userGuess, secretNumber);
            } else {
                this.saveGuess(userGuess);
                nextGuess(userGuess, secretNumber);
            }
            if (!this.isGuessInRange(userGuess)) {
                System.out
                        .println(userGuess + " is NOT a number in the valid range. Please enter a whole number between "
                                + MIN_POSSIBLE_GUESS + " and " + MAX_POSSIBLE_GUESS + ":");
            }
            return false;
        }
    }

    // You may want to create a method to print the user's previous guesses

    /**
     * Prints the user's previously guessed numbers.
     */
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
        System.out.println();
    }

    // You may want to create a method to store the user's guesses in the 8 elements
    // of the array

    /**
     * Saves the user's guess to inputGuess
     * 
     * @param guess The user's guessed integer
     */
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
    public int getInput(int min, int max) {
        // TODO: Complete this method by using the assignment's instructions
        // Do NOT use recursion for this assignment.

        Scanner keyboard = new Scanner(System.in);
        while (isPlaying) {
            if (keyboard.hasNextInt()) {
                int userInput = keyboard.nextInt();
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    System.out.println(
                            userInput + " is NOT a number in the valid range. Please enter a whole number between "
                                    + min + " and " + max + ":");
                }
            } else {
                String invalidInput = keyboard.next();
                System.out.println(invalidInput + " is NOT a whole number. Please enter a whole number:");
            }
        }
        return -1; // This line should never be reached
    }

    // You may want to create a boolean method to check that the user's guess is
    // within range (between a minimum and maximum)
    // and will return true if it is
    private boolean isGuessInRange(int guess) {
        return guess >= MIN_POSSIBLE_GUESS && guess <= MAX_POSSIBLE_GUESS;
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
        return guess == secretNumber;
    }

    // You may want to create a method to give a hint about the number guessed
    // (e.g., "My secret number is GREATER than " or "My secret number is LESS than
    // ")
    private String getHint(int guess, int secretNumber) {
        if (guess < secretNumber) {
            return "The secret number is GREATER than " + guess + ".";
        } else {
            return "The secret number is LESS than " + guess + ".";
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
        if (choice == 1) {
            // Reset guessesLeft and inputGuess array for a new game
            guessesLeft = MAX_GUESSES;
            inputGuess = new int[MAX_GUESSES];
        } else if (choice == 0) {
            System.out.println("Exiting game...");
            isPlaying = false;
        }
        return choice;
    }

    /**
     * Main method for playing the game.
     * 
     * @return User input for whether or not to play the game again.
     */
    public int playGuessingGame() {
        int secretNumber = this.getRandomNumber(); // Feel free to move this into another method

        this.welcome(); // You might call a welcome() method here instead
        isPlaying = true;
        // You might create a loop here that will check numberGuesses 8 times and print
        // the guess number and call the
        // pertinent method (e.g., isGuessNum)
        while (guessesLeft > 0) {
            System.out
                    .println("Enter a whole number between " + MIN_POSSIBLE_GUESS + " and " + MAX_POSSIBLE_GUESS + ":");
            if (this.isGuessNum(secretNumber)) {
                System.out.println("You won!");
                return this.playGame();
            }
        }
        System.out.println("Sorry, you have used all your guesses. The secret number was " + secretNumber + ".");

        // You might call and capture results from method (e.g., playGame) to see if
        // user wants to play again and if
        // so return it. Example: int playAgain = this.playGame();
        int playAgain = this.playGame();

        return playAgain; // if you want to end the game early & go directly back to main,
        // you can use a "return;" statement like this one (e.g., return playAgain;)
    }

}
