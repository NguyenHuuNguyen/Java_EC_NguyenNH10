package java_core_bai8;

public class LibraryCard {
	private String cardID;
	private int borrowDate;
	private int dueDate;
	private int bookNumber;
	private Student student;

	public LibraryCard(String cardID, int borrowDate, int dueDate, int bookNumber, Student student) {
		super();
		this.cardID = cardID;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.bookNumber = bookNumber;
		this.student = student;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public int getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(int borrowDate) {
		this.borrowDate = borrowDate;
	}

	public int getDueDate() {
		return dueDate;
	}

	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}