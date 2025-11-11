
// TODO: Don't forget to import the Scanner class for Part 5
import java.util.Scanner;

/*
 * The PrintHelper class has the methods for printing various shapes
 */
class PrintHelper {
    // Your methods to print various shapes goes here
    public void printStars(int width) {
        System.out.println("Stars:");
        int whichCol = 0;
        while (whichCol < width) {
            System.out.print("*");
            ++whichCol;
        }
        // Print just a new-line character
        System.out.println("");
    }

    public void printRectangle(int width, int height) {
        System.out.println("Rectangle:");
        // TODO: Change this method's incomplete code to use nested for-loops
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // TODO: Add more methods for printing shapes here:

    public void printRectangleHollow(int width, int height) {
        System.out.println("Hollow Rectangle:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printLeftTriangle(int height) {
        System.out.println("Left Triangle");
        for (int i = height; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class PrintingShapes extends Object {
    public static void main(String[] args) {
        // TODO: You will also add more code to this main method
        PrintHelper printer = new PrintHelper();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello! How many stars would you like me to print?");
        if (keyboard.hasNextInt()) {
            printer.printStars(keyboard.nextInt());
        } else
            return;

        System.out.println("For a rectangle, how wide should it be?");
        int width;
        int height;
        if (keyboard.hasNextInt()) {
            width = keyboard.nextInt();
        } else
            return;

        System.out.println("How high should it be?");
        if (keyboard.hasNextInt()) {
            height = keyboard.nextInt();
        } else
            return;
        printer.printRectangle(width, height);
        width = 0;
        height = 0;

        System.out.println("For a hollow rectangle, how wide should it be?");
        if (keyboard.hasNextInt()) {
            width = keyboard.nextInt();
        } else
            return;
        System.out.println("How high should it be?");
        if (keyboard.hasNextInt()) {
            height = keyboard.nextInt();
        } else
            return;
        printer.printRectangleHollow(width, height);

        System.out.println("For a left triangle, how high should it be?");
        if (keyboard.hasNextInt()) {
            printer.printLeftTriangle(keyboard.nextInt());
        } else
            return;

    }
}
