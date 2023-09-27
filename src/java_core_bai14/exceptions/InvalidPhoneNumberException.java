package java_core_bai14.exceptions;

public class InvalidPhoneNumberException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPhoneNumberException(String message) {
        super(message);
    }
}