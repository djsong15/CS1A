import becker.robots.*;

class RobotSmarter extends Robot {
	// CONSTRUCTOR
	RobotSmarter(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void moveThree() {
		int counter = 0;
		while (counter < 3) {
			this.move();
			counter = counter + 1;
		}
	}

	public void moveMultiple(int numberOfIntersections) { // parameter
		int counter = 0; // local variable
		while (counter < numberOfIntersections) {
			this.move();
			counter = counter + 1; // counter is assigned: (the current value of
									// counter plus 1)
		}
		System.out.println("BEFORE numberOfIntersections is : " + numberOfIntersections);

		numberOfIntersections = 100000;
		System.out.println("AFTER numberOfIntersections is : " + numberOfIntersections);
	}

	public void turnLeft(int numTurns) {
		int counter = 0;
		while (counter < numTurns) {
			turnLeft();
			counter++;
		}
	}
}