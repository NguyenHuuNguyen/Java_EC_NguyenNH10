package java_core_bai9;

public class ElectricBill {
	private HouseHold houseHold;
	private int oldElectricMeterValue;
	private int newElectricMeterValue;
	private int paymentAmount;

	public ElectricBill(HouseHold houseHold, int oldElectricMeterValue, int newElectricMeterValue) {
		this.houseHold = houseHold;
		this.oldElectricMeterValue = oldElectricMeterValue;
		this.newElectricMeterValue = newElectricMeterValue;
		this.paymentAmount = (newElectricMeterValue - oldElectricMeterValue) * 5;
	}

	public HouseHold getHouseHold() {
		return houseHold;
	}

	public void setHouseHold(HouseHold houseHold) {
		this.houseHold = houseHold;
	}

	public int getOldElectricMeterValue() {
		return oldElectricMeterValue;
	}

	public void setOldElectricMeterValue(int oldElectricMeterValue) {
		this.oldElectricMeterValue = oldElectricMeterValue;
	}

	public int getNewElectricMeterValue() {
		return newElectricMeterValue;
	}

	public void setNewElectricMeterValue(int newElectricMeterValue) {
		this.newElectricMeterValue = newElectricMeterValue;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public void showBill() {
		System.out.println("----------------------");
		houseHold.showHouseHold();
		System.out.println("Old electric value: " + oldElectricMeterValue);
		System.out.println("New electric value: " + newElectricMeterValue);
		System.out.println("Payment amount: " + paymentAmount);
		
	}
}
