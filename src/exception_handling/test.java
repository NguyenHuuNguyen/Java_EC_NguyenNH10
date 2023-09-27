package exception_handling;

import java.io.FileReader;
import java.util.Scanner;

public class test {
	public static int divideNumber(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a and b: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = divideNumber(a, b);
		System.out.println("Result: " + result);
		System.out.println("Do something next");
		sc.close();
		
		//FileReader asd = new FileReader(null);
	}
}
