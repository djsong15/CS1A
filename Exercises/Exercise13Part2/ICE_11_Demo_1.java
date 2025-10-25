import becker.robots.City;
import becker.robots.Direction;

public class ICE_11_Demo_1 extends Object {
    public static void main(String[] args) {
        City wallville = new City(-3, 0, 12, 12);
        RobotSmarter rob = new RobotSmarter(wallville, -2, 0, Direction.SOUTH, 0);
        System.out.println(rob.getIntersection());

        rob.moveThree();
        System.out.println(rob.getIntersection());
        rob.turnLeft();

        // 3 is a "literal" number
        rob.moveMultiple(3); // 3 is an "argument"
        System.out.println(rob.getIntersection());
        rob.turnLeft(3);

        // Notice how we can use a variable to
        // store the value (3) that we want to use as
        // a parameter:
        int howFar = 3;
        System.out.println("BEFORE how far is : " + howFar);
        rob.moveMultiple(howFar); // howFar is an "argument"
        System.out.println("AFTER how far is : " + howFar);
        System.out.println(rob.getIntersection());
        int howFarSECOND_NAME = 3;

        rob.moveMultiple(howFar);
        System.out.println(rob.getIntersection());

        // And of course, we can use other numbers:
        rob.turnLeft();
        rob.moveMultiple(2);
        System.out.println(rob.getIntersection());
    }
}
