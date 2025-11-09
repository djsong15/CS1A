
// You may use the nested comments below as hints only. Remember, there is no one right or wrong way
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;

/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: <br>
 * TODO: REPLACE THIS CAPITALIZED TEXT WITH THE DESCRIPTION OF THIS CLASS <br>
 * TODO: REPLACE THIS CAPITALIZED TEXT WITH THE DESCRIPTION OF HOW TO WIN MOST
 * EFFICIENTLY <br>
 *
 * @author student 1's given and family name
 * @author student 2's given and family name
 * @author student 3's given and family name
 */
public class GuessingGame extends Object
{
    // List any instance variables, including constants, here.
    private static final int MAX_POSSIBLE_GUESS = 64; // This is a constant
    // Use an array instance variable to hold the guesses

    private Random randomNumberGenerator = new Random();

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

    // You may want to create a method (e.g., isGuessNum) that will check to see
    // that the number entered is a whole number,
    // assign it to a variable like userGuess, and then handle all
    // the various options regarding that number: has it been guessed before?; is it
    // the secret number?; if it isn't the secret number store it in the proper
    // location for cross checking; display messages regarding the number of guesses
    // made,
    // incorrect guesses, guesses remaining, secret number if all guesses used up,
    // error handling, etc.

    // You may want to create a method to print the user's previous guesses

    // You may want to create a method to store the user's guesses in the 8 elements
    // of the array

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
    }

    // You may want to create a boolean method to check that the user's guess is
    // within range (between a minimum and maximum)
    // and will return true if it is

    // You may want to create a boolean method to see if the number has been guessed
    // previously and will return true if it has

    // You may want to create a boolean method to see if the number matches the
    // secret number and will return true if it does or false if it doesn't

    // You may want to create a method to give a hint about the number guessed
    // (e.g., "My secret number is GREATER than " or "My secret number is LESS than
    // ")

    // You may want to create a method (e.g., playGame) that will check if the user
    // wants to play again, by calling the method for getting integer input from the
    // user,
    // (1 for 'yes', 0 for 'no') and incorporate the proper functionality depending
    // on the user's choice ( 1 or 0).

    public void playGuessingGame()
    {
        int secretNumber = this.getRandomNumber(); // Feel free to move this into another method

        System.out.println("Hello!"); // You might call a welcome() method here instead

        // You might create a loop here that will check numberGuesses 8 times and print
        // the guess number and call the
        // pertinent method (e.g., isGuessNum)

        // You might call and capture results from method (e.g., playGame) to see if
        // user wants to play again and if
        // so return it. Example: int playAgain = this.playGame();

        return; // if you want to end the game early & go directly back to main,
                // you can use a "return;" statement like this one (e.g., return playAgain;)
    }

}
