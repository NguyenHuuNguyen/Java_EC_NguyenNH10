package java_core_bai14.view;

import common.Utilities;
import java_core_bai14.bll.StudentManager;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("====Student Management System====");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Select candidates");
            System.out.println("4. Exit");
            System.out.print("Input choice(1-7): ");
            int choice = Utilities.instance().getValidatedNumber(1, 3, Integer.class);

            switch (choice) {
                case 1:
                	StudentManager.instance().addStudent();
                    break;
                case 2:
                	StudentManager.instance().showAllStudents();
                    break;
                case 3:
                	StudentManager.instance().selectCandidates();
                    break;
                case 4:
                	System.out.println("===== Exited =====");
                    System.exit(0);
                    break;
                default:
                	System.out.println("Invalid choice");
            }
            Utilities.instance().scanner.nextLine();
        }
    }
}
