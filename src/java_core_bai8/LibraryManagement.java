package java_core_bai8;

import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class LibraryManagement {
	private List<LibraryCard> libraryCards = new ArrayList<>();
    private static LibraryManagement _instance;

    private LibraryManagement() {
    }

    public static LibraryManagement instance() {
        if (_instance == null) {
            _instance = new LibraryManagement();
        }
        return _instance;
    }
    
    public void showLibraryCards() {
    	if (libraryCards.isEmpty()) {
    		System.out.println("There is no card to show.");
    		return;
    	}
    	
    	System.out.println("====Lybrary Cards====");
        for (LibraryCard card : libraryCards) {
            System.out.println("Card ID: " + card.getCardID());
            System.out.println("Borrow Date: " + card.getBorrowDate());
            System.out.println("Due Date: " + card.getDueDate());
            System.out.println("Book Number: " + card.getBookNumber());
            Student student = card.getStudent();
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Class: " + student.getClassName());
            System.out.println("------------------------------");
        }
    }
    
    public void addLibraryCard() {
        System.out.print("Enter Student Name: ");
        String studentName = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid name format. Re-enter: ");

        System.out.print("Enter Age: ");
        int age = Utilities.instance().getValidatedNumber(1, 120, Integer.class);

        System.out.print("Enter Class: ");
        String className = Utilities.instance().getValidatedString("^[a-zA-Z0-9 ]+$", "Invalid class format. Re-enter: ");

        System.out.print("Enter Book Number: ");
        int bookNumber = Utilities.instance().getValidatedNumber(1, Integer.MAX_VALUE, Integer.class);

        System.out.print("Enter Borrow Date: ");
        int borrowDate = Utilities.instance().getValidatedNumber(1, 9999, Integer.class);

        System.out.print("Enter Due Date: ");
        int dueDate = Utilities.instance().getValidatedNumber(borrowDate + 1, 1000, Integer.class);

        System.out.print("Enter CardID: ");
        String cardID = Utilities.instance().getNewPrimaryKey("cardID");
        
        LibraryCard libraryCard = new LibraryCard(cardID, borrowDate, dueDate, bookNumber, new Student(studentName, age, className));
        libraryCards.add(libraryCard);

        System.out.println("Library card added successfully.");
    }

    public void removeLibraryCard() {
    	if (libraryCards.isEmpty()) {
    		System.out.println("There is no card to remove.");
    		return;
    	}
    	
        System.out.print("Enter Card ID to Remove: ");
        String cardID = Utilities.instance().getExistingPrimaryKey("cardID");

        for (LibraryCard card : libraryCards) {
            if (card.getCardID().equals(cardID)) {
                libraryCards.remove(card);
                System.out.println("Library card removed successfully.");
                return;
            }
        }

        System.out.println("Library card not found.");
    }
}
