import java.util.Scanner;

public class Arrays_With_Loops extends Object {
    public static void main(String[] args) {
        // First: Create an array
        double[] arr = new double[5];
        // Second: Use a while loop to set the array elements' values
        int i = 1;
        while (i <= 5) {
            arr[i - 1] = i;
            i++;
        }
        // Third: Use a for loop to print out the array
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }
}