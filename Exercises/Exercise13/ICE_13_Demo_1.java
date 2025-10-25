import becker.robots.*;

class SpinningRobot extends Robot {
	public void turnLeft() {
		// The first 4 times 'spins' the robot around
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
		// This last one actually turns the robot left of where it started.
		super.turnLeft();
	}

	SpinningRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void move2() {
		super.turnLeft(); // where do we go from here?
	}

}

public class ICE_13_Demo_1 extends Object {
	public static void main(String[] args) {
		City DizyCity = new City(10, 10);
		SpinningRobot joe = new SpinningRobot(DizyCity, 3, 3, Direction.EAST, 0);

		// Call 'turnleft' - notice that this goes to line 4,
		// instead of the Robot's version of turnLeft
		joe.turnLeft();

		// Since we didn't override move with our own version,
		// this still does the normal Robot.move thing
		joe.move();
	}
}
