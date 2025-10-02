/* REMINDER:  This sample solution is provided with the requirement that you
 * will NOT reproduce or distribute it.
 *
 * Copyright 2006 by Byron Weber Becker 
 */
 
import becker.robots.*;

/** A class of robots that plants Things in the form of a hollow rectangle.
 *
 * @author Byron Weber Becker */
public class RectanglePlanter extends RobotSE
{
	/** Create a new rectangle planter. 
	 * @param aCity The robot's city.
	 * @param aStreet The robot's initial street.
	 * @param anAvenue The robot's initial avenue.
	 * @param aDir The robot's initial direction.
	 * @param numThings The number of things initially in the robot's backpack. */
   public RectanglePlanter(City aCity, int aStreet, int anAvenue, Direction aDir, int numThings)
   {	super(aCity, aStreet, anAvenue, aDir, numThings);
   }
   
   /** Plant a hollow rectangle of Things.  The robot must be positioned in the
    * rectangle's upper-left corner facing east.
    * @param width The number of avenues wide.
    * @param height The number of streets high. */
   public void plantRect(int width, int height)
   {  this.plantSide(width);
      this.plantSide(height);
      this.plantSide(width);
      this.plantSide(height);
   }
   
	/** Plant one side of the rectangle with Things, beginning with the next intersection.
	* @param length The length of the line. */
   protected void plantSide(int length)
   {  length = length - 1;
   	this.plantLine(length);
      this.turnRight();
   }
   
   /** Plant a line of Things beginning with the intersection in front of the robot.
    * @param length The length of the line. */
   protected void plantLine(int length)
   {  while (length > 0)
      {  this.move();
         this.plantIntersection();
         length = length - 1;
      }
   }
   
   /** Plant one intersection. */
   protected void plantIntersection()
   {  this.putThing();
   }
}