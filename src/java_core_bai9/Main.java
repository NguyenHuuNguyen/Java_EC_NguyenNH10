package java_core_bai9;

import common.Utilities;

public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Bill Management =====");
			System.out.println("1. Add new household");
			System.out.println("2. Edit household");
			System.out.println("3. Delete household");
			System.out.println("4. Add new bill");
			System.out.println("5. Show all households");
			System.out.println("6. Show all bills");
			System.out.println("7. Exit");
			System.out.print("Input choice(1-7): ");
			int choice = Utilities.instance().getValidatedNumber(1, 7, Integer.class);

			switch (choice) {
			case 1:
				BillManagement.instance().addHouseHold();
				break;
			case 2:
				BillManagement.instance().editHouseHold();
				break;
			case 3:
				BillManagement.instance().deleteHouseHold();
				break;
			case 4:
				BillManagement.instance().addBill();
				break;
			case 5:
				BillManagement.instance().showHouseHolds();
				break;
			case 6:
				BillManagement.instance().showBills();
				break;
			case 7:
				System.out.println("===== Exited =====");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
			
			Utilities.instance().scanner.nextLine();
		}
	}

}
