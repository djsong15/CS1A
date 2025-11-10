import java.util.Scanner;

public class Grades_Array extends Object {
    public static void main() {
        double[] grades = new double[5];
        double total = 0;
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter grade #" + (i + 1) + ": ");
            boolean gotGrade = false;
            while (!gotGrade) {
                if (keyboard.hasNextDouble()) {
                    grades[i] = keyboard.nextDouble();
                    total += grades[i];
                    gotGrade = true;
                } else {
                    keyboard.next();
                }
            }
            System.out.println(grades[i]);
        }
        System.out.println("The average grade is: " + (total / 5));

        System.out.println("Enter a grade:");
        boolean gotInput = false;
        while (!gotInput) {
            if (keyboard.hasNextDouble()) {
                double userInputGrade = keyboard.nextDouble();
                for (int i = 0; i < 5; i++) {
                    if (grades[i] == userInputGrade) {
                        System.out.println("Found the grade at index " + i);
                        return;
                    }
                }
                System.out.println("Grade not found");
                gotInput = true;
            } else {
                keyboard.next();
            }
        }
    }
}