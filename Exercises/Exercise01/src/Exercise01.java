import becker.robots.*;

/*
 Make sure that the name of the file is the same as the name of the class
 with ".java" on the end.
 The name of the class is found between the words "class", and "extends".
 For example, the name of this class is "Exercise01",
 so this file MUST be named "Exercise01.java" or it won't
 compile into "Exercise01.class" and it can not be run as a program.
 */
public class Exercise01 extends java.lang.Object 
{
	public static void main(String[] args) 
	{
		City theCity = new City();
		Robot karel = new Robot(theCity, 1, 0, Direction.EAST, 0);
		Thing theThing = new Thing(theCity, 2, 2);
		
		new Wall(theCity, 2, 2, Direction.EAST);
		new Wall(theCity, 2, 2, Direction.NORTH);
		new Wall(theCity, 2, 2, Direction.WEST);
		
		new Wall(theCity, 3, 2, Direction.SOUTH);
		
		/* TODO: Put your code below this comment. */
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		if (karel.canPickThing()) {
			karel.pickThing();
		}
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.move();
		if (karel.countThingsInBackpack() >= 1) {
			karel.putThing();
		}
		karel.move();
	}
}
