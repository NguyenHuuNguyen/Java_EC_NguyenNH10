package java_core_bai12;

import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class VehicleManager {
	private List<Vehicle> vehicles = new ArrayList<>();
    private static VehicleManager _instance;

    public static VehicleManager instance() {
        if (_instance == null) {
            _instance = new VehicleManager();
        }
        return _instance;
    }

    private VehicleManager() {
    }
    
    public void addVehicle() {
        System.out.print("Enter vehicle type (Car/Motorcycle/Truck): ");
        String vehicleType = Utilities.instance().getValidatedString(
            "^(Car|Motorcycle|Truck)$",
            "Invalid vehicle type. Please enter Car, Motorcycle, or Truck: "
        );

        System.out.print("Enter ID: ");
        String id = Utilities.instance().getNewPrimaryKey("ID");
        
        System.out.print("Enter manufacturer: ");
        String manufacturer = Utilities.instance().getValidatedString(
            "^[a-zA-Z ]+$",
            "Invalid manufacturer format. Please use only letters and spaces: "
        );

        System.out.print("Enter year manufactured: ");
        int yearManufactured = Utilities.instance().getValidatedNumber(
            1900, 2030, Integer.class
        );

        System.out.print("Enter price: ");
        double price = Utilities.instance().getValidatedNumber(0.0, 1000000.0, Double.class);

        System.out.print("Enter color: ");
        String color = Utilities.instance().getValidatedString(
            "^[a-zA-Z ]+$",
            "Invalid color format. Please use only letters and spaces: "
        );

        Vehicle vehicle;
        if (vehicleType.equalsIgnoreCase("Car")) {
            System.out.print("Enter seats: ");
            int seats = Utilities.instance().getValidatedNumber(1, 10, Integer.class);

            System.out.print("Enter engine type: ");
            String engineType = Utilities.instance().getValidatedString(
                "^[a-zA-Z ]+$",
                "Invalid engine type format. Please use only letters and spaces: "
            );

            vehicle = new Car(id, manufacturer, yearManufactured, price, color, seats, engineType);
        } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            System.out.print("Enter horsepower: ");
            int horsepower = Utilities.instance().getValidatedNumber(1, 10000, Integer.class);

            vehicle = new Motorcycle(id, manufacturer, yearManufactured, price, color, horsepower);
        } else {
            System.out.print("Enter payload: ");
            double payload = Utilities.instance().getValidatedNumber(1.0, 10000.0, Double.class);

            vehicle = new Truck(id, manufacturer, yearManufactured, price, color, payload);
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle with ID " + id + " added.");
    }
    
    public void showAllVehicles() {
        showVehicles(this.vehicles);
    }
    
    public void showVehicles(List<Vehicle> vehicles) {
    	if (vehicles.isEmpty()) {
            System.out.println("There is no vehicle to show.");
            return;
        }
        
        System.out.println("====Vehicles list====");

        for (Vehicle vehicle : vehicles) {
        	System.out.println("------------------------");
            vehicle.showInfo();
        }
    }
    
    public void deleteVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found to delete.");
            return;
        }

        System.out.print("Enter the vehicle ID to delete: ");
        String idToDelete = Utilities.instance().getExistingPrimaryKey("ID");

        boolean removed = vehicles.removeIf(vehicle -> vehicle.getId().equals(idToDelete));

        if (removed) {
            System.out.println("Vehicle with ID " + idToDelete + " has been deleted.");
        } else {
            System.out.println("Vehicle with ID " + idToDelete + " was not found.");
        }
    }
    
    public void findVehicles() {
        List<Vehicle> foundVehicles = new ArrayList<>();
        
        System.out.println("1. Search by manufacturer");
        System.out.println("2. Search by color");
        System.out.print("Select search criteria: ");
        int choice = Utilities.instance().getValidatedNumber(1, 2, Integer.class);

        if (choice == 1) {
            System.out.print("Enter manufacturer: ");
            String manufacturer = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid manufacturer format. Please use only letters and spaces: ");
            
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getManufacturer().matches(manufacturer)) {
                    foundVehicles.add(vehicle);
                }
            }
        } else if (choice == 2) {
            System.out.print("Enter color: ");
            String color = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid color format. Please use only letters and spaces: ");
            
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getColor().matches(color)) {
                    foundVehicles.add(vehicle);
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }

        if (foundVehicles.isEmpty()) {
        	System.out.println("There is no vehicle match the search method.");
        	return;
        }
        showVehicles(foundVehicles);
    }
}
