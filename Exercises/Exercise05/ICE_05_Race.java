import becker.robots.*;

import java.util.Random; // to generate random numbers

class RelayRacer extends Robot {
    public RelayRacer(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }

    public void turnRight() {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }

    public void batonPass(RelayRacer nextRacer) {
        if (this.getStreet() > nextRacer.getStreet()) {
            this.turnLeft();
        } else if (this.getStreet() < nextRacer.getStreet()) {
            this.turnRight();
        }
        while (this.getStreet() != nextRacer.getStreet()) {
            this.move();
        }
        this.putThing();
    }
}

public class ICE_05_Race extends Object {
    public static void main(String[] args) {
        City RaceCity = new City(4, 11);
        Random numberGenerator = new Random(); // don't worry about this line

        Thing baton = new Thing(RaceCity, 3, 0);

        // karel is the first racer (at the left)
        // and always starts directly above the baton
        RelayRacer karel = new RelayRacer(RaceCity, 3, 0, Direction.EAST, 0);

        // bob is the second racer (in the middle)
        RelayRacer bob = new RelayRacer(RaceCity, 2, 2 + numberGenerator.nextInt(3), Direction.EAST, 0);
        bob.setColor(java.awt.Color.blue);

        // mary is the third racer (at the right)
        RelayRacer mary = new RelayRacer(RaceCity, 3, 5 + numberGenerator.nextInt(3), Direction.EAST, 0);
        mary.setColor(java.awt.Color.green);

        /*
         * karel should pick up the baton, then move to the intersection that bob is in.
         * karel should drop the baton, bob should pick it up, and bob should then move
         * to the intersection that mary is in. bob should drop the baton, mary should
         * pick it up, and mary should then move 2 intersections east, and drop the
         * baton.
         */
        karel.pickThing();
        while (karel.getAvenue() < bob.getAvenue()) {
            karel.move();
        }
        karel.batonPass(bob);

        bob.pickThing();
        while (bob.getAvenue() < mary.getAvenue()) {
            bob.move();
        }
        bob.batonPass(mary);

        mary.pickThing();
        // mary should run to Ave 18
        while (mary.getAvenue() < 18) {
            mary.move();
        }
        mary.turnRight();
        // mary should run to St 5
        while (mary.getStreet() < 5) {
            mary.move();
        }
        mary.putThing();
    }
}
