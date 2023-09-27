package java_core_bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Constants;
import common.Utilities;

public class BillManagement {
	private List<HouseHold> houseHolds = new ArrayList<>();
	private List<ElectricBill> bills = new ArrayList<>();
	private static BillManagement _instance;

	public static BillManagement instance() {
		if (_instance == null) {
			_instance = new BillManagement();
		}
		return _instance;
	}

	private BillManagement() {

	}

	public List<HouseHold> getHouseHolds() {
		return houseHolds;
	}

	public List<ElectricBill> getBills() {
		return bills;
	}

	public void addHouseHold() {
		System.out.print("Meter number: ");
		String meterNumber = Utilities.instance().getNewPrimaryKey(Constants.METER_NUMBER);
		System.out.print("Owner name: ");
		String ownerName = Utilities.instance().getValidatedString("^[a-zA-Z]+( [a-zA-Z]+)*$",
				"Inbvalid, re-input Owner name:");
		System.out.print("Address: ");
		String address = Utilities.instance().getValidatedString("^(?!\\s*$).+$", "Address:");
		this.houseHolds.add(new HouseHold(meterNumber, address, ownerName));
	}

	public void editHouseHold() {
		if (this.houseHolds.isEmpty()) {
			System.out.println("There is no HouseHold to update!");
			return;
		}
		showHouseHolds();
		System.out.println("Meter number: ");
		String meterNumber = Utilities.instance().getExistingPrimaryKey(Constants.METER_NUMBER);
		System.out.print("Owner name: ");
		String ownerName = Utilities.instance().getValidatedString("^[a-zA-Z]+( [a-zA-Z]+)*$",
				"Inbvalid, re-input Owner name:");
		System.out.print("Address: ");
		String address = Utilities.instance().getValidatedString("^(?!\\s*$).+$", "Address:");
		HouseHold houseHold = this.houseHolds.stream()
				                             .filter(h -> h.getElectricMeterNumber().equalsIgnoreCase(meterNumber))
				                             .findFirst()
				                             .orElse(null);
		houseHold.updateHouseHold(address, ownerName);
		System.out.println("HouseHold with Meter number " + meterNumber + " updated");
	}

	public void deleteHouseHold() {
		if (this.houseHolds.isEmpty()) {
			System.out.println("There is no HouseHold to delete!");
			return;
		}
		showHouseHolds();
		System.out.println("Meter number: ");
		String meterNumber = Utilities.instance().getExistingPrimaryKey(Constants.METER_NUMBER);
		this.houseHolds = this.houseHolds.stream()
										 .filter(h -> !h.getElectricMeterNumber()
										 .equalsIgnoreCase(meterNumber))
										 .collect(Collectors.toList());
		System.out.println("HouseHold with Meter number " + meterNumber + " deleted");
	}

	public void addBill() {
		showHouseHolds();
		String meterNumber = Utilities.instance().getExistingPrimaryKey(Constants.METER_NUMBER);
		System.out.print("Old electric number(0-99999): ");
		int oldNumber = Utilities.instance().getValidatedNumber(0, 99999, Integer.class);
		System.out.print(String.format("Old electric number(%s-99999): ", oldNumber));
		int newNumber = Utilities.instance().getValidatedNumber(oldNumber + 1, 99999, Integer.class);
		final String temp = meterNumber;
		HouseHold houseHold = houseHolds.stream()
										.filter(h -> h.getElectricMeterNumber().equalsIgnoreCase(temp))
										.findFirst()
										.orElse(null);
										
		bills.add(new ElectricBill(houseHold, oldNumber, newNumber));
	}

	public void showBills() {
		System.out.println("------List bills------");
		if (this.bills.isEmpty()) {
			System.out.println("There is no Bill to show!");
			return;
		}
		this.bills.stream().forEach(b -> b.showBill());
	}

	public void showHouseHolds() {
		System.out.println("------HouseHold list------");
		if (this.houseHolds.isEmpty()) {
			System.out.println("There is no HouseHold to show!");
			return;
		}
		this.houseHolds.stream().forEach(h -> h.showHouseHold());
	}
}
