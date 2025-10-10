import becker.robots.*;
import java.util.Random; // to use the "Random" class

class GpsBot extends Robot {
    public GpsBot(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }

    public void turnAround() {
        this.turnLeft();
        this.turnLeft();
    }

    public void navigate() {
        if (this.frontIsClear()) {
            this.move();
        } else {
            this.turnLeft();
            if (!this.frontIsClear()) {
                this.turnAround();
            }
        }
    }

    public void findThing() {
        while (!this.canPickThing()) {
            this.navigate();
        }
        this.pickThing();
    }

    public void returnHome() {
        // home is (5,6)
        while (this.getAvenue() != 5 || this.getStreet() != 6) {
            this.navigate();
        }
    }
}

public class HallwaysWhile extends Object {
    // These are a couple of new commands that belong to the program
    // rather than any particular robot.
    // For right now, don't worry about how these work :)
    public static void hallwayN(City c, int st, int ave, int streetsNorth) {
        for (int i = 0; i < streetsNorth; i++) {
            new Wall(c, st - i, ave, Direction.WEST);
            new Wall(c, st - i, ave, Direction.EAST);
        }
    }

    public static void setupCity(City c) {
        // North hallway:
        hallwayN(c, 5, 5, 5);
        new Wall(c, 1, 5, Direction.NORTH);
        new Thing(c, 1, 5);

        // West hallway:
        hallwayN(c, 5, 4, 5);
        new Wall(c, 1, 4, Direction.NORTH);
        new Wall(c, 6, 4, Direction.WEST);
        new Wall(c, 6, 4, Direction.SOUTH);
        new Thing(c, 1, 4);

        // southern hallway
        hallwayN(c, 9, 4, 2);
        new Wall(c, 7, 4, Direction.WEST);
        new Wall(c, 7, 5, Direction.EAST);
        new Wall(c, 7, 5, Direction.SOUTH);
        new Wall(c, 9, 4, Direction.SOUTH);
        new Thing(c, 9, 4);

        // eastern hallway
        new Wall(c, 6, 6, Direction.EAST);
        new Wall(c, 6, 6, Direction.NORTH);
        new Wall(c, 6, 6, Direction.SOUTH);
        new Thing(c, 6, 6);
    }

    public static Direction pickDirection() {
        Random r = new Random(System.currentTimeMillis());
        return switch (r.nextInt(4)) {
            case 0 -> Direction.NORTH;
            case 1 -> Direction.WEST;
            case 2 -> Direction.EAST;
            case 3 -> Direction.SOUTH;
            default -> Direction.SOUTH; // to keep the compiler happy
        };
    }

    public static void main(String[] args) {
        City toronto = new City(11, 8);
        GpsBot Jo = new GpsBot(toronto, 6, 5, pickDirection(), 0);
        setupCity(toronto); // ignore this line for now

        /* Your code should go here: */
        Jo.findThing();
        Jo.turnAround();
        Jo.returnHome();
    }
}
