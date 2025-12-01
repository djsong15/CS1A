class PrintHelper extends Object {

	public double[] getTemperatures() {
		double[] temps = new double[7];
		temps[0] = 5.6;
		temps[1] = 2;
		for (int i = 2; i < temps.length; i++)
			temps[i] = (i + 1) * 3 + 17;
		return temps;
	}

	public void printArray(double[] arr) {
		// // print out all the elements of the array that will be passed
		// // to this method.
		// // This method (and all the others) should be able operate on the
		// // array that getTemperatures produces

        // a for-each loop is cleaner and appropriate if we never need to
        // access index numbers of an array
		for (double i : arr) {
			System.out.println(i);
		}
	}

	public double averageArray(double[] arr) {
		// total up the array, then return the average
		double ttl = 0;

        // again, a for-each is cleaner than a regular for-loop here
		for (double i : arr) {
			ttl += i;
		}
		return ttl / arr.length;
	}

	public double[] clonePlusTwo(double[] arr) {
		// create a new array, each element is 2 higher than the original

        // store clone array in a new variable that we'll return
		double[] newArr = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i] + 2;
		}

		return newArr;
	}

	public void upByTwo(double[] arr) {
		// This method will be given an array. The method will then increase
		// the value of each element of that array by two.

        // this method should only mutate the given array
        // no need to clone here
		for (int i = 0; i < arr.length; i++) {
			arr[i] += 2;
		}
	}

}

public class ParamReturnValuePractice extends Object {
	public static void main(String[] args) {
		PrintHelper ph = new PrintHelper();

		double[] ts = new double[3];
		ts = ph.getTemperatures();
		System.out.println("Temperatures:");
		ph.printArray(ts);
		ph.upByTwo(ts);
		System.out.println("New Temperatures:");
		ph.printArray(ts);
		double[] clone2 = ph.clonePlusTwo(ts);
		ts[0] = 88;
		System.out.println("Cloned Temperatures:");
		ph.printArray(clone2);
		System.out.println("Average of Cloned Temperatures: " + ph.averageArray(clone2));

        double[] newArr = new double[5];
        int i = 0;
        while (i < newArr.length) {
            newArr[i] = i + 6;
            i++;
        }
        for (double el : newArr) {
            System.out.println(el);
        }
	}
}
