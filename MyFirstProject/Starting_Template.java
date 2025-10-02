import becker.robots.*;
/*
 * Starting Template:
 * This file was created in order to provide you with a pre made 'starter' program
 */

public class Starting_Template extends java.lang.Object 
{
	public static void main(String[] args) 
   {
		City toronto = new City();
		Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
		new Thing(toronto, 3, 2);

		/* Your code should go below this comment: */
		jo.move();
		jo.move();
		jo.pickThing();
		jo.move();
		jo.putThing();
		jo.turnLeft();
		jo.move();
	} 
}
