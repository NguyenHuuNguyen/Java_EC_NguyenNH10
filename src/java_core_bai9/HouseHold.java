package java_core_bai9;

public class HouseHold {
	private String electricMeterNumber;
	private String address;
	private String householdOwnerName;

	public HouseHold(String electricMeterNumber, String address, String householdOwnerName) {
		super();
		this.electricMeterNumber = electricMeterNumber;
		this.address = address;
		this.householdOwnerName = householdOwnerName;
	}

	public String getElectricMeterNumber() {
		return electricMeterNumber;
	}

	public void setElectricMeterNumber(String electricMeterNumber) {
		this.electricMeterNumber = electricMeterNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseholdOwnerName() {
		return householdOwnerName;
	}

	public void setHouseholdOwnerName(String householdOwnerName) {
		this.householdOwnerName = householdOwnerName;
	}

	public void showHouseHold() {
		String output = String.format("Electric meter number: %-7s | Owner name: %-15s | Address: %s",
				electricMeterNumber, householdOwnerName, address);
		System.out.println(output);
	}
	public void updateHouseHold(String address, String ownerName) {
		this.address = address;
		this.householdOwnerName = ownerName;
	}
}
