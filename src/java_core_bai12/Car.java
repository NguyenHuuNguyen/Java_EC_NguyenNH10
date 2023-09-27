package java_core_bai12;

public class Car extends Vehicle {
    private int seats;
    private String engineType;

    public Car(String id, String manufacturer, int yearManufactured, double price, String color, int seats, String engineType) {
        super(id, manufacturer, yearManufactured, price, color);
        this.seats = seats;
        this.engineType = engineType;
    }

    @Override
    public void showInfo() {
    	System.out.println("Car ID: " + getId());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Year Manufactured: " + getYearManufactured());
        System.out.println("Price: " + getPrice());
        System.out.println("Color: " + getColor());
        System.out.println("Seats: " + seats);
        System.out.println("Engine Type: " + engineType);
    }
}
