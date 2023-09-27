package exception_handling;

import java.io.IOException;

public class ThrowAndThrows {
	static class CustomExceptionClass extends Exception {
		CustomExceptionClass(String message) {
			super(message);
		}
		
		@Override
		public String getMessage() {
			System.out.println("lam gi thi lam");
			return "lam gi lam";
		}
	}

	static void func() {
		System.out.println("Do something");
		try {
			String a = null;        // ngầm định
			a.charAt(0);            // ngầm định
			throw new CustomExceptionClass("exception ne`"); // tường minh
		}
		catch(NullPointerException e){
			System.out.println("exception xay ra");
		}
		catch(CustomExceptionClass e) {
			System.out.println("asdasdasd");
		}
	}

	public static void main(String[] args) {
		// Với checked exception thì phải dùng try catch
		// Hoặc tiếp tục throw ra method cha để xử lý
		try {
			func();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			StackTraceElement[] stktrace = e.getStackTrace();
			for (int i = 0; i < stktrace.length; i++) {
				System.out.println("Index " + i + " of stack trace" + " array contains = " + stktrace[i].toString());
			}
		}
	}
}
