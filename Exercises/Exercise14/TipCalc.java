
// notice that we don't have "import becker.robots.*;" anymore
import java.util.Scanner;

public class TipCalc extends Object {
    public static void main(String[] args) {
        // Notice how we don't need to setup the city anymore

        // create a new Scanner
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please type in the cost of the meal");

        // double precision floating point number
        double costOfMeal = 0;

        if (keyboard.hasNextDouble()) { // if user typed in a whole number
            // go and get the number
            costOfMeal = keyboard.nextDouble();
            if (costOfMeal >= 0) {
                double tip15 = costOfMeal * 0.15;
                double tip20 = costOfMeal * 0.2;
                double tip30 = costOfMeal * 0.3;

                // print out tip15, tip20, tip30
                System.out.println("tip15: " + tip15);
                System.out.println("tip20: " + tip20);
                System.out.println("tip30: " + tip30);
            } else {
                System.out.println("Cost can't be negative!");
            }
        } else {
            System.out.println("Type in a whole number");
        }
        keyboard.nextLine();
        keyboard.close();

        System.out.println("Cost is: " + costOfMeal);

        // boolean - true/false
        boolean mealIsPricey = costOfMeal > 20;

        // Examples of assigning a true/false value to a boolean variable:
        // mealIsPricey = false;
        // mealIsPricey = 1 < 4;

        // You'll need to fill in what you really want to assign
        // to mealIsPricey here:

        // We now use the boolean variable:
        if (mealIsPricey)
            System.out.println("the meal is expensive");
    }
}
