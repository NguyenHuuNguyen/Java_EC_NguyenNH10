package java_core_bai12;

public abstract class Vehicle {
    private String id;
    private String manufacturer;
    private int yearManufactured;
    private double price;
    private String color;

    public Vehicle(String id, String manufacturer, int yearManufactured, double price, String color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.yearManufactured = yearManufactured;
        this.price = price;
        this.color = color;
    }

    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
