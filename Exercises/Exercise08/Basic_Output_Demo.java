import becker.robots.*;

public class Basic_Output_Demo extends Object
{
    public static void main(String[] args)
    {
        System.out.println("THE PROGRAM STARTS HERE!!");
        System.out.print("Hi!");
        System.out.print("Hello");
        System.out.println(""); // nothing to print except the new line

        City wallville = new City(10, 10);
        Robot rob = new Robot(wallville, 7, 0, Direction.EAST, 0);
        new Thing(wallville, 7, 0);
        new Thing(wallville, 7, 3);

        int counter = 0;

        System.out.println("Setup   \"done\", start executing commands!");
        System.out.println("Counter is starting at: " + counter + " 'cause that's how we do it in CS!");

        while (counter < 3)
        {
            System.out.println("Before move, Counter is: " + counter);
            rob.move();
            counter = counter + 1; // counter is assigned the current value of
                                   // i, plus 1
            System.out.println("After move, Counter is: " + counter);
        }

        int extraNumber = 10;
        System.out.println(
                "After the loop, rob's avenue is: \"" + rob.getAvenue() + "\" and extraNumber is: " + extraNumber);

        System.out.println("THE PROGRAM ENDS HERE!!");
    }
}
