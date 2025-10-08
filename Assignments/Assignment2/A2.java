/*
 * Daniel Song
 * CS1A, Fall'24
 * Assignment 2.0
 */

import becker.robots.*;
import java.util.Random;

class BetterRobot extends Robot
{
    public BetterRobot(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    // make a 180° turn
    public void turnAround()
    {
        this.turnLeft();
        this.turnLeft();
    }

    // make a 270° turn
    public void turnRight()
    {
        this.turnAround();
        this.turnLeft();
    }

    // move while front is clear
    public void moveToWall()
    {
        while (this.frontIsClear())
        {
            this.move();
        }
    }

    /* get thing at end of hall
    move to the end, grab thing, turn around, move back to start */
    public void fetchThing()
    {
        this.moveToWall();
        this.pickThing();
        this.turnAround();
        this.moveToWall();
    }

    // after exiting a hall, turn left, move down to the next hall, turn left again
    public void uTurn()
    {
        this.turnLeft();
        this.move();
        this.turnLeft();
    }

    /* while we have things in backpack,
    move once, drop thing */
    public void dropOffThings()
    {
        while (this.countThingsInBackpack() > 0)
        {
            this.move();
            this.putThing();
        }
    }

    /* from end of last hall
     * turn around and go back to start
     * then turn right move all the way back up
     * turn right, back to starting position
     */
    public void returnHome()
    {
        this.turnAround();
        this.moveToWall();
        this.turnRight();
        this.moveToWall();
        this.turnRight();
    }

    /*
     * do everything in sequence
     * grab things at end of each hall
     * drop off all things at last hall
     * return home
     */
    public void doEverything()
    {
        int counter = 0;
        while (counter < 4)
        {
            this.fetchThing();
            this.uTurn();
            ++counter;
        }

        this.dropOffThings();

        this.returnHome();
    }
}

public class A2 extends Object
{
    public static void main(String[] args)
    {
        City wallville = new City(6, 12);
        BetterRobot rob = new BetterRobot(wallville, 1, 2, Direction.EAST, 0);

        A2.buildCity(wallville); // this calls the "BuildCity" method, below

        /*
         * TODO: * * * * * Your code to race around the race track goes here! * * * *
         * HINT: Several while loops would work well for this particular exercise. One
         * possible solution would be to start with a while loop (for checking the
         * count) that contains two nested while loops used to check whether the front
         * is clear before performing some actions. Jumping through this initial while
         * loop might use additional while loops to continue checking whether the front
         * is clear before performing other actions in order to complete the tasks of
         * the maze.
         */

        rob.doEverything();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // No need to touch any of the code below.
    // All it does is construct the maze in the city.
    /////////////////////////////////////////////////////////////////////////////////////////
    public static void buildCity(City wallville)
    {
        // Width and height must be at least 2 (each)
        // Feel free to change these numbers, and see how your race track changes

        Random randomNumberGenerator = new Random();
        int top = 1;
        int left = 2;
        int height = 4;
        int width = 4 + randomNumberGenerator.nextInt(7);

        int streetNumber = top;
        while (streetNumber <= height)
        {
            if (streetNumber == 1)
            {
                // the topmost line:
                new Wall(wallville, streetNumber, left, Direction.NORTH);
            } else if (streetNumber == height)
            {
                // generate the 'holding spot' thing at the bottom: the corner:
                new Wall(wallville, streetNumber + 1, left, Direction.WEST);
                new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
                int spotNum = left + 1;
                int counter = 0;
                while (counter < height)
                {
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
                    // Uncomment the next line for a 'final state' picture (i.e., the second picture
                    // in the assignment)
                    // new Thing(wallville, streetNumber + 1, spotNum);
                    ++spotNum;
                    ++counter;
                }
                new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
            }

            // the most western, vertical line:
            new Wall(wallville, streetNumber, left, Direction.WEST);
            // the most eastern, vertical line:
            new Wall(wallville, streetNumber, width, Direction.EAST);
            // the Thing at the end of the tunnel
            new Thing(wallville, streetNumber, width);

            int aveNum = left + 1;
            while (aveNum <= width)
            {
                new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
                new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
                ++aveNum;
            }

            ++streetNumber;
        }
    }
}
