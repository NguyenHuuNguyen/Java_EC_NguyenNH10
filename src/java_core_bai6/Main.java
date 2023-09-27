package java_core_bai6;

import common.Utilities;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = StudentManagement.instance();

        while (true) {
            System.out.println("===== Student Management =====");
            System.out.println("1. Add new student");
            System.out.println("2. Show students at 20 years old");
            System.out.println("3. Show number of students aged 23 from DN");
            System.out.println("4. Show all students");
            System.out.println("5. Exit");
            System.out.print("Input choice (1-5): ");
            int choice = Utilities.instance().getValidatedNumber(1, 5, Integer.class);

            switch (choice) {
                case 1:
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.showStudentsAt20();
                    break;
                case 3:
                    studentManagement.showNumberOfStudents23FromDN();
                    break;
                case 4:
                    studentManagement.showAllStudents();
                    break;
                case 5:
                    System.out.println("===== Exited =====");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
            Utilities.instance().scanner.nextLine();
        }
    }
}