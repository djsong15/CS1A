
//
// YOUR JOB IS TO FILL IN THE chooseDirection COMMAND, SO THAT THE ROBOT
// MOVES FROM ONE END OF THE PIPE TO THE OTHER.
//
//
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

class RobotThatFollowsThePipe extends Robot {
	public RobotThatFollowsThePipe(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void chooseDirection() {
		if (this.canPickThing()) {
			this.turnLeft();
		} else if (!this.frontIsClear()) {
			this.turnRight();
		} else {
			this.move4();
		}
	}

	// In case you want to use a 'turnRight' command, here it is:
	public void turnRight() {
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}

	public void move4() {
		int i = 0;
		while (i < 4) {
			this.move();
			++i;
		}
	}

	public void travel() {
		this.move4();
		this.chooseDirection();
	}
}

public class Ex_04_If_Else extends Object {
	// These are a couple of new commands that belong to the program
	// rather than any particular robot.
	// For right now, don't worry about how these work :)
	public static void hallwayN(City c, int st, int ave, int streetsNorth) {
		for (int i = 0; i < streetsNorth; i++) {
			new Wall(c, st - i, ave, Direction.WEST);
			new Wall(c, st - i, ave, Direction.EAST);
		}
	}

	public static void hallwayE(City c, int st, int ave, int streetsEast) {
		for (int i = 0; i < streetsEast; i++) {
			new Wall(c, st, ave + i, Direction.NORTH);
			new Wall(c, st, ave + i, Direction.SOUTH);
		}
	}

	public static void setupCity(City c) {
		hallwayE(c, 4, 2, 3);
		new Wall(c, 4, 1, Direction.NORTH);
		new Wall(c, 4, 1, Direction.WEST);
		new Wall(c, 4, 1, Direction.SOUTH);

		hallwayN(c, 3, 5, 3);
		new Wall(c, 4, 5, Direction.EAST);
		new Wall(c, 4, 5, Direction.SOUTH);
		new Thing(c, 4, 5);

		hallwayE(c, 0, 6, 3);
		new Wall(c, 0, 5, Direction.NORTH);
		new Wall(c, 0, 5, Direction.WEST);

		hallwayN(c, 3, 9, 3);
		new Wall(c, 0, 9, Direction.EAST);
		new Wall(c, 0, 9, Direction.NORTH);

		hallwayE(c, 4, 10, 8);
		new Wall(c, 4, 9, Direction.WEST);
		new Wall(c, 4, 9, Direction.SOUTH);
		new Thing(c, 4, 9);

		new Wall(c, 4, 17, Direction.NORTH);
		new Wall(c, 4, 17, Direction.EAST);
		new Wall(c, 4, 17, Direction.SOUTH);
	}

	public static void main(String[] args) {
		City toronto = new City(6, 20);
		RobotThatFollowsThePipe Jo = new RobotThatFollowsThePipe(toronto, 4, 1, Direction.EAST, 0);
		setupCity(toronto); // ignore this line for now

		while (Jo.frontIsClear()) {
			Jo.travel();
		}
	}
}
