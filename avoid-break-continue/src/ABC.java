/**
 * Whenever you find you are using while(true), break, or continue, there is
 * probably a better way to write your code.<br>
 * The same goes for using "for (;;) {".
 * 
 * @author Dr. Baba Kofi Weusijana
 */
public class ABC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 100;
		int i = 0;

		/*
		 * This code is commented out because it has an infinite loop.
		 */
//		i = 0;
//		for (;;) {
//			System.out.print(++i + " ");
//		}
		/*
		 * This code is commented out because it has an infinite loop.
		 */
//		i = 0;
//		while (true) {
//			System.out.print(++i + " ");
//		}
//		System.out.print("\n");

		// Works, but sloppy
		i = 0;
		while (true) {
			System.out.print(++i + " ");
			if (i == max) {// If max is too high you could still lock-up your application and the bug could
							// be hard to find and fix
				break;
			}
		}
		System.out.print("\n");

		// Not sure of how to start? Use a boolean variable instead! Then refacter
		// (improve the code without changing its purpose) later.
		boolean notFinishedYet = true;
		i = 0;
		while (notFinishedYet) {
			System.out.print(++i + " ");
			if (i == max) {
				notFinishedYet = false;
			}
		}
		System.out.print("\n");

		// Refactored to be simpler/better!
		i = 0;
		while (i < max) {
			System.out.print(++i + " ");
		}
		System.out.print("\n");

//		// If you must run the loop at least once, you can use a do-while loop
		i = 0;
		do {
			System.out.print(++i + " "); // This line will always run at least once
		} while (i < max); // before this boolean test is considered
		System.out.print("\n");

		// Skipping 50 using continue
		i = 0;
		while (i < max) {
			if (i == 49) {
				++i;
				continue;
			}
			System.out.print(++i + " ");
		}
		System.out.print("\n");

		// Refactored to be easier to understand/read!
		i = 0;
		while (i < max) {
			if (i == 49) {
				++i;
			} else {
				System.out.print(++i + " ");
			}
		}
		System.out.print("\n");
	}
}
