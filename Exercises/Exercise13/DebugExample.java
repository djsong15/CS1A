   // DEMO: Debug Example
   //////////////////////////////////////////////////////////////////////////////////////////////////
   import becker.robots.*;

   public class DebugExample extends Robot
   {
      public DebugExample(City theCity, int street, int avenue, Direction aDirection, int backpack)
      {  
         super(theCity, street, avenue, aDirection, backpack);
      }
   
      public void turnAround()
      {  
         this.turnLeft();
         this.turnLeft();
      }
   
      public void moveSome(int moveMe)
      {  
         int counter = 0;
         while(moveMe > counter)
         {
            if(!this.canPickThing())
            {
               this.putThing();
            }
            if(this.frontIsClear())
            {
               this.move();
            } 
            else
            {
               System.out.println("Reached a wall! Game over, man!");
               //System.exit(0); // <-- THIS SNIPPET OF CODE WILL CLOSE THE PROGRAM
            }           
            counter++;
         }
         //System.out.print("MOVE DATA --> ");
         //System.out.println(this);
      }
   
      public void turnRight()
      {  
         this.turnAround();
         this.turnLeft();
         //System.out.print("TURNING RIGHT --> ");
         //System.out.println(this);
      }
   
      public static void main(String[] args)
      {  City bothell = new City(0,-5,10,20); // <-- Note: Setting Up City Dimensions in negative territory
         DebugExample rigby = new DebugExample(bothell, 3, 2, Direction.SOUTH, 1000);
         new Wall(bothell, 2, -1, Direction.NORTH);
         //new Wall(bothell, 4, 3, Direction.EAST);
      
         System.out.println("I'm going to keep moving until I reach a wall :-)\n");
         System.out.println(rigby);
         rigby.moveSome(5);
         rigby.turnRight();
         rigby.moveSome(5);
         rigby.turnAround();
         rigby.moveSome(4);
         rigby.turnLeft();
         System.out.println(rigby);
         rigby.moveSome(4);
         rigby.turnAround();
         rigby.turnLeft();
         rigby.moveSome(10);
         System.out.println(rigby);
         rigby.turnRight();
         rigby.moveSome(2);
         rigby.turnRight();
         rigby.moveSome(12);
         System.out.println(rigby);
         rigby.turnRight();
         rigby.moveSome(5);
         System.out.println(rigby);
      }
   }
