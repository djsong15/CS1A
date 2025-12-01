import becker.robots.*;

class RobotThatCanWalkDownAWall extends Robot {
    RobotThatCanWalkDownAWall(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }
    
    // Your code should go here:
    public boolean isNorthOfStreet(int st) {
        return this.getStreet() < st;
    }

    public boolean isSouthOfStreet(int st) {
        return this.getStreet() > st;
    }
}

public class ICE_19 extends Object {
    public static void main(String[] args) {
        City wallingford = new City();
        RobotThatCanWalkDownAWall jo = new RobotThatCanWalkDownAWall(wallingford, 2, 2, Direction.NORTH, 0);

        /* build tower*/
        new Wall(wallingford, 1, 1, Direction.EAST);
        new Wall(wallingford, 2, 1, Direction.EAST);
        new Wall(wallingford, 3, 1, Direction.EAST);

        System.out.println("Is Jo north of street 1? " + jo.isNorthOfStreet(1));
        System.out.println("Is Jo north of street 3? " + jo.isNorthOfStreet(3));
        System.out.println("Is Jo north of street 2? " + jo.isNorthOfStreet(2));
        jo.move();
        System.out.println("Is Jo north of street 2? " + jo.isNorthOfStreet(2));

        jo.turnLeft();
        jo.turnLeft();
        System.out.println("Is Jo south of street 4? " + jo.isSouthOfStreet(4));
        while (!jo.isSouthOfStreet(4)) {
            jo.move();
        }
        System.out.println("Is Jo south of street 4? " + jo.isSouthOfStreet(4));

   }
}
