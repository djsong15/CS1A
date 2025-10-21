import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

import java.util.Scanner;

/*
Starting Template:
This file was created in order to provide you with a pre made 'starter' program
*/
public class Rep_I_O extends Object {
    public static void main(String[] args) {
        City toronto = new City();
        Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
        new Thing(toronto, 3, 2);
        /* Your code should after here: */
        Scanner keyboard = new Scanner(System.in);
        int userChoice = 0;

        while (userChoice != 5) {
            System.out.println("Type 1 if you want the robot to turn left");
            System.out.println("Type 2 if you want the robot to move 1 intersection");
            System.out.println("Type 3 if you want the robot to pick up thing");
            System.out.println("Type 4 if you want the robot to put down thing");
            System.out.println("Type 5 if you want to quit the program");

            if (keyboard.hasNextInt()) {
                userChoice = keyboard.nextInt();
            } else {
                System.out.println("Type a valid number please");
            }
            keyboard.nextLine();

            switch (userChoice) {
                case (1) -> jo.turnLeft();
                case (2) -> jo.move();
                case (3) -> jo.pickThing();
                case (4) -> jo.putThing();
                case(5) -> System.out.println("Goodbye");
            }
        }

    }
}
