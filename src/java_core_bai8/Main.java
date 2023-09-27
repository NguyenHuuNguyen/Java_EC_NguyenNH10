package java_core_bai8;

import common.Utilities;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Library Card");
            System.out.println("2. Remove Library Card");
            System.out.println("3. Show Library Cards");
            System.out.println("4. Exit");
            System.out.print("Input choice (1-4): ");
            int choice = Utilities.instance().getValidatedNumber(1, 4, Integer.class);

            switch (choice) {
                case 1:
                    LibraryManagement.instance().addLibraryCard();
                    break;
                case 2:
                    LibraryManagement.instance().removeLibraryCard();
                    break;
                case 3:
                    LibraryManagement.instance().showLibraryCards();
                    break;
                case 4:
                    System.out.println("===== Exited =====");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
            Utilities.instance().scanner.nextLine();
        }
    }
}