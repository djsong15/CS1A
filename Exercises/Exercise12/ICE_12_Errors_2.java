import becker.robots.*;

import javax.sound.midi.SysexMessage;

// This robot will be able to keep track of how many
// moves it's made, and then be able to print a message to
// the user saying that.
class MoveRobot extends Robot {
    // type variables before declaring them; in this case, mark private as well
    private int numberOfMovesMade = 0;
    private int numberOfLeftTurns = 0;

    MoveRobot(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }

    public void moveCounted() {
        this.move();
        // increment numberOfMovesMade by 1 after every move
        this.numberOfMovesMade++;
    }

    public void printNumberOfMoves() {
        System.out.println("Since I started counting, I moved:");
        System.out.println(this.numberOfMovesMade);
        System.out.println("times!");
    }

    public void leftTurnCounted() {
        this.turnLeft();
        this.numberOfLeftTurns++;
    }

    public void printNumberOfLeftTurns() {
        System.out.println("Since I started counting left turns, I made:");
        System.out.println(this.numberOfLeftTurns);
        System.out.println("left turns!");
    }
}

public class ICE_12_Errors_2 extends Object {
    public static void main(String[] args) {
        City ForgetsVille = new City();
        MoveRobot mary = new MoveRobot(ForgetsVille, 4, 1, Direction.EAST, 0);
        new Wall(ForgetsVille, 2, 5, Direction.NORTH);
        // CityFrame frame = new CityFrame(ForgetsVille);

        // First keep track of these 4
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.printNumberOfMoves();

        mary.leftTurnCounted();

        // no semicolon necessary after while condition
        while (mary.frontIsClear()) {
            // all functions are called with parentheses
            mary.moveCounted();
        }
        // methods are called with a '.'
        mary.printNumberOfMoves();
        mary.printNumberOfLeftTurns();
    }
}
