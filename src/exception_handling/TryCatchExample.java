package exception_handling;

public class TryCatchExample {

	public static void main(String[] args) {
		try {
			// code có khả năng gây exception sẽ để ở đây
			//System.out.println("7/0 gay nen exception");
			System.out.println("7/2 gay nen ko co exception");
			int a = 7 / 2;
		} catch (Exception e) {
			// catch block sẽ được thực thi khi exception xẩy ra
			System.out.println("Bat exception: " + e.getMessage());
		} finally {
			// finally block sẽ luôn được thực hiện
			System.out.println("Luc nao cung se chay");
		}
	}

}
