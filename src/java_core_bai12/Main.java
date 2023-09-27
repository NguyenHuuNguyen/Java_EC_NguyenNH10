package java_core_bai12;

import java.util.InputMismatchException;

import common.Utilities;

public class Main {
	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Vehicle Management =====");
			System.out.println("1. Add new vehicle");
			System.out.println("2. Remove vehicle");
			System.out.println("3. Find vehicles by manufacturer or color");
			System.out.println("4. Show all vehicles");
			System.out.println("5. Exit");
			System.out.print("Enter your choice (1-5): ");

			try {
				int choice = Utilities.instance().getValidatedNumber(1, 5, Integer.class);

				switch (choice) {
				case 1:
					VehicleManager.instance().addVehicle();
					break;
				case 2:
					VehicleManager.instance().deleteVehicle();
					break;
				case 3:
					VehicleManager.instance().findVehicles();
					break;
				case 4:
					VehicleManager.instance().showAllVehicles();
					break;
				case 5:
					System.out.println("===== Exiting =====");
					System.exit(0);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid option.");
			}
			
			Utilities.instance().scanner.nextLine();
		}
	}
}
