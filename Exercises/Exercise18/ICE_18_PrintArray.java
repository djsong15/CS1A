class ArrayHelper1 extends Object {
    public void PrintArray(int[] arrArg) {
        // Your code goes here - use
        // the "process all elements" pattern, where the work
        // to be done is printing each element
        for (int i : arrArg) {
            System.out.println(i);
        }

        /*
         * using enhanced for loop above, traditional for loop below
         * for (int i = 0; i < arrArg.length; i++) {
         *   System.out.println(arrArg[i]);
         * }
         */
    }
}

public class ICE_18_PrintArray extends Object {
    public static void main(String[] args) {
        ArrayHelper1 ah = new ArrayHelper1();

        // Now set up the array stuff, which is more interesting:
        int[] shortArray = new int[4];
        int i;
        for (i = 0; i < shortArray.length; i++) {
            shortArray[i] = (i + 1) * 2;
        }

        int[] longArray = new int[14];
        for (i = 0; i < longArray.length; i++) {
            longArray[i] = (i + 1) * 3;
        }
        // print out both arrays
        ah.PrintArray(shortArray);
        ah.PrintArray(longArray);
    }
}