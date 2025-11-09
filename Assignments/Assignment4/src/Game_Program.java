/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: <br>
 * TODO: REPLACE THIS CAPITALIZED TEXT WITH THE DESCRIPTION OF THIS CLASS <br>
 *
 * @author student 1's given and family name
 * @author student 2's given and family name
 * @author student 3's given and family name
 */
public class Game_Program extends Object
{
    public static void main(String[] args)
    {
        GuessingGame guessingGameObject = new GuessingGame(); // feel free to add arguments to the constructor, if it
                                                              // helps...

        int playing = 1;
        while (playing == 1) {
            playing = guessingGameObject.playGuessingGame();
            /*
             * Do whatever else you need to in order to: Step 1:figure out if the game
             * should be played again or that the entire program should quit and Step 2: set
             * the playing variable accordingly. You MUST have the
             * guessingGameObject.playGuessingGame() method return something, so you will
             * have a variable capture that return (for example you could use the playing
             * variable for that) and use that variable to stop or continue the already
             * written while loop. One example way: if guessingGameObject.playGuessingGame()
             * == 0 then show a message and quit the game. Remember to adhere to the
             * "Program Guidelines" module item from the first week of the course, such as
             * NOT using the break or continue keywords.
             * Do NOT use recursion for this assignment.
             */
        }
    }
}
