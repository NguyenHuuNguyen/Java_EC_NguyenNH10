package java_core_bai5;

import common.Utilities;

public class Main {
	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Hotel Management =====");
			System.out.println("1. Add new customer");
			System.out.println("2. Delete customer");
			System.out.println("3. Add new rent detail");
			System.out.println("4. Show customer list");
			System.out.println("5. Cash out for customer");
			System.out.println("6. Exit");
			System.out.print("Input choice (1-6): ");
			int choice = Utilities.instance().getValidatedNumber(1, 6, Integer.class);

			switch (choice) {
			case 1:
				HotelManagement.instance().addCustomer();
				break;
			case 2:
				HotelManagement.instance().deleteCustomer();
				break;
			case 3:
				HotelManagement.instance().addRentDetail();
				break;
			case 4:
                HotelManagement.instance().showCustomers();
                break;
			case 5:
				HotelManagement.instance().cashOut();
				break;
			case 6:
				System.out.println("===== Program Exited =====");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
			Utilities.instance().scanner.nextLine();
		}
	}
}