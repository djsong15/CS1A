import java.util.Scanner;

class ArrayHelper extends Object {
    // Copy this from the previous in class exercise
    public void PrintArray(int[] arrArg) {
        for (int i : arrArg) {
            System.out.println(i);
        }
    }

    // This is the code you need to fill in
    public void FindInArray(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found " + target + " at index " + i);
                return;
            }
        }
    }
}

public class ICE_18_FindInArray extends Object {
    public static void main(String[] args) {
        ArrayHelper ah = new ArrayHelper();

        // Now set up the array stuff, which is more interesting:
        int[] shortArray = new int[4];
        int i;
        for (i = 0; i < shortArray.length; i++) {
            shortArray[i] = (i + 1) * 2;
        }

        int[] longArray = new int[14];
        // We want to put numbers into the long array in reverse order
        // we should thus count DOWN through the slot numbers,
        // and simultaneously have counter count UP
        int counter = 0;
        for (i = longArray.length - 1; i >= 0; i--) {
            longArray[i] = (counter + 1) * 3;
            counter++;
        }

        System.out.println("Short Array: ");
        ah.PrintArray(shortArray); // FIX THIS
        System.out.println("Long Array:  ");
        ah.PrintArray(longArray); // FIX THIS

        ah.FindInArray(shortArray, 2); // SHOULD TELL US THAT '2' WAS FOUND AT SLOT 0
        ah.FindInArray(longArray, 10); // SHOULD NOT PRINT ANYTHING
    }
}