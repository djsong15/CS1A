import becker.robots.*;
import java.util.Scanner;

public class Basic_Keyboard_IO extends Object {
    public static void main(String[] args) {
        System.out.println("THE PROGRAM STARTS HERE!!");

        int numMoves = 0;
        int counter = 0;

        Scanner keyboard = new Scanner(System.in);

        City sf = new City();
        Robot mary = new Robot(sf, 1, 1, Direction.EAST, 0);
        System.out.println("mary.getAvenue():" + mary.getAvenue());

        System.out.println("How many intersections forward would you like the robot to go?");
        if (keyboard.hasNextInt()) {
            numMoves = keyboard.nextInt(); // nextInt actually gets the input
        } else {
            System.out.println("You did NOT type in a whole number!");
        }
        keyboard.nextLine(); // DON'T FORGET TO CLEAR ANY REMAINING INPUT!!
        keyboard.close(); // You don't have to close the Scanner resource, but
        // it is good practice to do so
        
        System.out.println("You asked to move " + numMoves + " spaces");
        counter = 0;
        while (counter < numMoves) {
            mary.move();
            System.out.println("mary.getAvenue():" + mary.getAvenue());
            System.out.println("counter has been updated to:" + ++counter);
        }
        System.out.println("counter is finally:" + counter);
        System.out.println("THE PROGRAM ENDS HERE!!");
    }
}
