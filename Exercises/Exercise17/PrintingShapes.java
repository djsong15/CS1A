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

		printer.printStars(7);
		printer.printRectangle(5, 3);
        printer.printRectangleHollow(3, 5);
        printer.printRectangleHollow(4, 5);
        printer.printRectangleHollow(2, 2);
        printer.printLeftTriangle(5);
	}
}
