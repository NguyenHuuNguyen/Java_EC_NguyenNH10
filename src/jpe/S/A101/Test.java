package jpe.S.A101;

public class Test {
	public static void recursiveFunction(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        recursiveFunction(n - 1);
    }

    public static void main(String[] args) {
        try {
            recursiveFunction(100000);
        } catch (StackOverflowError e) {
            System.out.println("Stack over flow: " + e.getStackTrace());
        }
    }

}
