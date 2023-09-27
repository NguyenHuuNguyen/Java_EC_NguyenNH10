package java_core_bai12;

public class Motorcycle extends Vehicle {
    private int horsepower;

    public Motorcycle(String id, String manufacturer, int yearManufactured, double price, String color, int horsepower) {
        super(id, manufacturer, yearManufactured, price, color);
        this.horsepower = horsepower;
    }

    @Override
    public void showInfo() {
    	System.out.println("Motorcycle ID: " + getId());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Year Manufactured: " + getYearManufactured());
        System.out.println("Price: " + getPrice());
        System.out.println("Color: " + getColor());
        System.out.println("Horsepower: " + horsepower);
    }
}
