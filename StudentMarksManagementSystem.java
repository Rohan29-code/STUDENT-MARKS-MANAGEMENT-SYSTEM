# STUDENT-MARKS-MANAGEMENT-SYSTEM
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    int[] marks = new int[3];
    int total;
    double average;
    char grade;

    Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        calculateResults();
    }

    void calculateResults() {
        total = 0;
        for (int m : marks) {
            total += m;
        }
        average = total / 3.0;

        if (average >= 90)
            grade = 'A';
        else if (average >= 80)
            grade = 'B';
        else if (average >= 70)
            grade = 'C';
        else if (average >= 60)
            grade = 'D';
        else
            grade = 'F';
    }
}

public class StudentMarksManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Marks Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting program... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 3);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--;
            }
        }

        Student s = new Student(name, roll, marks);
        students.add(s);
        System.out.println("✅ Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found! Please add students first.");
            return;
        }

        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s%n", "Name", "RollNo", "Total", "Average", "Grade");
        System.out.println("-----------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-15s %-10d %-10d %-10.2f %-10c%n",
                    s.name, s.rollNumber, s.total, s.average, s.grade);
        }

        System.out.println("-----------------------------------------------------------");
    }
}
