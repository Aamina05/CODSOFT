import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int total = 0;

        // Input marks
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            // Validate input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks! Please enter between 0 and 100: ");
                marks[i] = sc.nextInt();
            }

            total += marks[i];
        }

        // Calculate average & percentage
        double average = (double) total / numSubjects;
        double percentage = (total * 100.0) / (numSubjects * 100);

        // Determine grade
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n--- Student Grade Report ---");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}