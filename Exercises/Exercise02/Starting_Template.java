import becker.robots.*;
/*
 * Starting Template:
 * This file was created in order to provide you with a pre made 'starter' program
 */

public class Starting_Template extends java.lang.Object 
{
	public static void main(String[] args) 
   {
		City cupertino = new City();
		Robot gretel = new Robot(cupertino, 1, 0, Direction.EAST, 0);
		Thing thing1 = new Thing(cupertino, 1, 2);
		
		new Wall(cupertino, 1, 1, Direction.NORTH);
		new Wall(cupertino, 1, 1, Direction.WEST);
		new Wall(cupertino, 1, 1, Direction.SOUTH);
		new Wall(cupertino, 1, 1, Direction.EAST);
	} 
}
