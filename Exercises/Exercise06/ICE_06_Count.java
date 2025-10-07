import becker.robots.*;

class RobotSmarter extends Robot {
	RobotSmarter(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }

	public void moveSix() {
		int i = 1;
		while (i <= 6) {
            this.move();
            ++i;
        }
	}
}

public class ICE_06_Count extends Object {
	public static void main(String[] args)
    {
        City wallville = new City(10, 10);
        RobotSmarter rob = new RobotSmarter(wallville, 7, 0, Direction.EAST, 0);
        RobotSmarter jo = new RobotSmarter(wallville, 7, 0, Direction.EAST, 0);

        new Thing(wallville, 7, 0);
        new Thing(wallville, 7, 6);
        new Thing(wallville, 1, 6);

        rob.moveSix();
        rob.turnLeft();
        rob.moveSix();
    }
}
