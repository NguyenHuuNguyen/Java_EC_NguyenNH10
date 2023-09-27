package java_core_bai5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RoomRentDetail {
	private int roomNumer;
	private Customer customer;
	private RoomType roomtype;
	private LocalDate startDate;
	private LocalDate endDate;

	public RoomRentDetail(int roomNumer, Customer customer, RoomType roomtype, LocalDate startDate, LocalDate endDate) {
		super();
		this.roomNumer = roomNumer;
		this.customer = customer;
		this.roomtype = roomtype;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getRoomNumer() {
		return roomNumer;
	}

	public void setRoomNumer(int roomNumer) {
		this.roomNumer = roomNumer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public RoomType getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public long getNumberOfDays() {
	    return ChronoUnit.DAYS.between(startDate, endDate);
	}

    public int getCost() {
        long numberOfDays = getNumberOfDays();
        return (int) (numberOfDays * roomtype.getPrice());
    }
}
