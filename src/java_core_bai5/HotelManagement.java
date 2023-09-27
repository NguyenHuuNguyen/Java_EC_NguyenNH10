package java_core_bai5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class HotelManagement {
	private static HotelManagement _instance;
	private List<Customer> customers = new ArrayList<>();
	private List<RoomRentDetail> roomRentDetails = new ArrayList<>();

	static public HotelManagement instance() {
		if (_instance == null) {
			_instance = new HotelManagement();
		}
		return _instance;
	}

	private HotelManagement() {

	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<RoomRentDetail> getRoomRentDetails() {
		return roomRentDetails;
	}

	public void setRoomRentDetails(List<RoomRentDetail> roomRentDetails) {
		this.roomRentDetails = roomRentDetails;
	}

	public void addCustomer() {
		System.out.print("Enter identity number: ");
		String identityNumber = Utilities.instance().getNewPrimaryKey("identityNumber");

		System.out.print("Enter name (letters and spaces only): ");
		String name = Utilities.instance().getValidatedString("^[a-zA-Z\\s]+$", "Invalid name. Re-enter: ");

		System.out.print("Enter age: ");
		int age = Utilities.instance().getValidatedNumber(1, 150, Integer.class);

		Customer customer = new Customer(identityNumber, name, age);
		customers.add(customer);
		System.out.println("Customer added: " + customer.getName());
	}
	
	public void showCustomers() {
        System.out.println("List of Customers:");
        System.out.println("----------------");
        for (Customer customer : customers) {
            customer.showInfor();
            System.out.println("----------------");
        }
    }

	public void deleteCustomer() {
		if(this.customers.isEmpty()) {
			System.out.println("There is no customer to delete.");
			return;
		}
		
		System.out.print("Enter identity number to delete: ");
		String identityNumber = Utilities.instance().getExistingPrimaryKey("identityNumber");

		Customer customerToDelete = findCustomerByIdentityNumber(identityNumber);

		if (customerToDelete != null) {
			roomRentDetails.removeIf(rentDetail -> rentDetail.getCustomer().equals(customerToDelete));
			customers.remove(customerToDelete);
			System.out.println("Customer deleted: " + customerToDelete.getName());
		} else {
			System.out.println("Customer with ID " + identityNumber + " not found.");
		}
	}

	public void addRentDetail() {
		if(this.customers.isEmpty()) {
			System.out.println("There is no customer to add rent detail.");
			return;
		}
		
		System.out.print("Enter identity number of the customer: ");
		String identityNumber = Utilities.instance().getExistingPrimaryKey("identityNumber");

		Customer customer = findCustomerByIdentityNumber(identityNumber);
		if (customer != null) {
			System.out.print("Enter room number: ");
			int roomNumber = Utilities.instance().getValidatedNumber(1, Integer.MAX_VALUE, Integer.class);

			System.out.print("Enter room type (A/B/C): ");
			String roomType = Utilities.instance().getValidatedString("^[A-C]$",
					"Invalid room type. Please enter A, B, or C: ");

			System.out.print("Enter start date (dd-MM-yyyy): ");
			LocalDate startDate = Utilities.instance().getValidatedDate("Invalid date format. Re-enter (dd-MM-yyyy): ",
					"Start date is out of range, re-input: ", "01-01-2000", "31-12-2100");
			
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formattedStartDate = startDate.format(dateFormat);
			System.out.print("Enter end date (dd-MM-yyyy): ");
			LocalDate endDate = Utilities.instance().getValidatedDate("Invalid date format. Re-enter (dd-MM-yyyy): ",
					"End date is out of range, re-input: ", formattedStartDate, "31-12-2100");

			RoomType type = null;
			switch (roomType) {
			case "A":
				type = new RoomType("A", 500);
				break;
			case "B":
				type = new RoomType("B", 300);
				break;
			case "C":
				type = new RoomType("C", 100);
				break;
			}

			RoomRentDetail rentDetail = new RoomRentDetail(roomNumber, customer, type, startDate, endDate);
			roomRentDetails.add(rentDetail);
			System.out.println("Rent detail added for customer: " + customer.getName());
		} else {
			System.out.println("Customer with ID " + identityNumber + " not found.");
		}
	}

	public void cashOut() {
		System.out.print("Enter identity number of the customer: ");
		String identityNumber = Utilities.instance().getExistingPrimaryKey("identityNumber");

		Customer customer = findCustomerByIdentityNumber(identityNumber);
		if (customer != null) {
			List<RoomRentDetail> customerRentDetails = getRentDetailsForCustomer(customer);

			System.out.println("Customer: " + customer.getName());
			System.out.println("Identity Number: " + customer.getIdentityNumber());
			System.out.println("Rent Details:");

			for (RoomRentDetail rentDetail : customerRentDetails) {
				System.out.println("Room Number: " + rentDetail.getRoomNumer());
				System.out.println("Room Type: " + rentDetail.getRoomtype().getType());
				System.out.println("Start Date: " + rentDetail.getStartDate());
				System.out.println("End Date: " + rentDetail.getEndDate());
				System.out.println("Cost: $" + rentDetail.getCost());
				System.out.println("------------");
			}
		} else {
			System.out.println("Customer with ID " + identityNumber + " not found.");
		}
	}

	private List<RoomRentDetail> getRentDetailsForCustomer(Customer customer) {
	    List<RoomRentDetail> customerRentDetails = new ArrayList<>();
	    for (RoomRentDetail rentDetail : roomRentDetails) {
	        if (rentDetail.getCustomer().equals(customer)) {
	            customerRentDetails.add(rentDetail);
	        }
	    }
	    return customerRentDetails;
	}
	
	private Customer findCustomerByIdentityNumber(String identityNumber) {
		for (Customer customer : customers) {
			if (customer.getIdentityNumber().equals(identityNumber)) {
				return customer;
			}
		}
		return null;
	}
}
