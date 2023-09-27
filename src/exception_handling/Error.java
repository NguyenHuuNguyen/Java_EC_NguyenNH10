package exception_handling;

public class Error {
	public static void HamDeQuy(int n) {
		//System.out.println(n);
		HamDeQuy(n - 1);
	}

	public static void main(String[] args) {
		try {
			HamDeQuy(100000);
		}
		catch (StackOverflowError e) {
			System.out.println("Do something");
		}
	}

}
