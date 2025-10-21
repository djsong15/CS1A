import becker.robots.*;
import java.util.Scanner;
/*
Starting Template:
This file was created in order to provide you with a pre made 'starter' program
*/
public class Basic_I_O extends Object {
    public static void main(String[] args) {
        City toronto = new City();
        Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
        new Thing(toronto, 3, 2);
        /* Your code should after here: */
        Scanner keyboard = new Scanner(System.in);
        int userChoice = 0;

        System.out.println("Type 1 if you want the robot to turn left");
        System.out.println("Type 2 if you want the robot to move 1 intersection");

        if (keyboard.hasNextInt()) {
            userChoice = keyboard.nextInt();
        }
        keyboard.nextLine();
        
        if (userChoice == 1) {
            jo.turnLeft();
        } else if (userChoice == 2) {
            jo.move();
        }
    }
}
