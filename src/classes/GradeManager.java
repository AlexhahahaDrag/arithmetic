package classes;

import java.util.Scanner;

public class GradeManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of grades to store in the array: ");
        int numGrades = scanner.nextInt();

        if (numGrades < 1 || numGrades > 50) {
            System.out.println("Array out of bound.");
            return;
        }

        int[] grades = new int[numGrades];

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                i--; // Retry the current index
            } else {
                grades[i] = grade;
            }
        }

        System.out.println("\nOriginal grades are:");
        System.out.println("--------------------");
        for (int i = 0; i < numGrades; i++) {
            System.out.println("Entry " + (i + 1) + " : " + grades[i]);
        }

        if (numGrades > 0) {
            double mean = calculateMean(grades);
            int[] tallies = getTallies(grades);
            int range = getRange(grades);
            int difference = increaseGrade(grades, mean);

            pringReport(mean, tallies, range, grades, difference);
        }
    }

    public static double calculateMean(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int[] getTallies(int[] grades) {
        int advance = 0, intermediate = 0, low = 0;
        for (int grade : grades) {
            if (grade >= 80) {
                advance++;
            } else if (grade >= 70) {
                intermediate++;
            } else {
                low++;
            }
        }
        return new int[]{advance, intermediate, low};
    }

    public static int getRange(int[] grades) {
        int min = grades[0], max = grades[0];
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
            if (grade > max) {
                max = grade;
            }
        }
        return max - min;
    }

    public static int increaseGrade(int[] grades, double mean) {
        System.out.println("grades:" + mean);
        int difference = 0;
        if (mean < 70) {
            difference = (int) Math.ceil(70 - mean);
            for (int i = 0; i < grades.length; i++) {
                grades[i] = Math.min(grades[i] + difference, 100);
            }
        }
        return difference;
    }

    public static void pringReport(double mean, int[] tallies, int range, int[] grades, int difference) {
        System.out.println("\nGrade report summary");
        System.out.println("--------------------");
        System.out.printf("Mean is: %.4f%n", mean);
        System.out.println("Total Advance Grades are: " + tallies[0]);
        System.out.println("Total Intermediate Grades are: " + tallies[1]);
        System.out.println("Total Low Grades are: " + tallies[2]);
        System.out.println("Range is: " + range);

        if (difference > 0) {
            System.out.println("\nUpdated grades by adding " + difference + " points are:");
            System.out.println("---------------------------------------");
            for (int i = 0; i < grades.length; i++) {
                System.out.println("Entry " + (i + 1) + " : " + grades[i]);
            }
        }
    }
}
