import java.util.Scanner;

public class Arrays_With_Loops extends Object {
    public static void main(String[] args) {
        // First: Create an array
        int[] arr = new int[5];
        // Second: Use a while loop to set the array elements' values
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        // Third: Use a for loop to print out the array
        for (int j : arr) {
            System.out.println(j);
        }
    }
}