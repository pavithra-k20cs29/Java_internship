package Java_Internship;

import java.util.Scanner;

public class AverageGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        int[] grades = new int[numGrades];
        int sum = 0;

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            sum += grades[i];
        }

        double average = (double) sum / numGrades;

        System.out.println("Average grade: " + average);

        scanner.close();
    }
}

