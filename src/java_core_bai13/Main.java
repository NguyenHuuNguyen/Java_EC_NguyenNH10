package java_core_bai13;

import common.Utilities;

public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Employee Management =====");
			System.out.println("1. Add new employee");
			System.out.println("2. Edit employee");
			System.out.println("3. Delete employee");
			System.out.println("4. Show all employees");
			System.out.println("5. Show employees with type");
			System.out.println("6. Exit");
			System.out.print("Input choice(1-6): ");
			int choice = Utilities.instance().getValidatedNumber(1, 6, Integer.class);

			switch (choice) {
			case 1:
				EmployeeManagement.instance().addEmployee();
				break;
			case 2:
				EmployeeManagement.instance().editEmployee();
				break;
			case 3:
				EmployeeManagement.instance().deleteEmployee();
				break;
			case 4:
				EmployeeManagement.instance().showEmployees();
				break;
			case 5:
				EmployeeManagement.instance().showEmployeesWithType();
				break;
			case 6:
				System.out.println("===== Exited =====");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
			
			Utilities.instance().scanner.nextLine();
		}
	}

}
