package java_core_bai12;

public class Truck extends Vehicle {
    private double payload;

    public Truck(String id, String manufacturer, int yearManufactured, double price, String color, double payload) {
        super(id, manufacturer, yearManufactured, price, color);
        this.payload = payload;
    }

    @Override
    public void showInfo() {
    	System.out.println("Truck ID: " + getId());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Year Manufactured: " + getYearManufactured());
        System.out.println("Price: " + getPrice());
        System.out.println("Color: " + getColor());
        System.out.println("Payload: " + payload);
    }
}