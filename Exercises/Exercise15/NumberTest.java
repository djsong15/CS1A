// EXAMPLE: A number goes in, a revised number comes out
/////////////////////////////////////////////////////////////////////////////////
class SumNum extends Object {
	// A simple method to add a '5' to any integer and return the value
	public int Tally(int num) {
		int sum = 0;
		sum = num + 5;
		return sum;
	}
}

public class NumberTest extends Object {
	public static void main(String[] args) {
		SumNum sn = new SumNum();

		int number;
		number = sn.Tally(3); // a '3' is entered here as argument in the
								// parameter and passed to SumNum method

		System.out.println(number); // The sum is returned and displayed here
	}
}
