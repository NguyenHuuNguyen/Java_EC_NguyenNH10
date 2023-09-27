package jpe.S.A101;

import java.util.Scanner;

public class ArithmeticExercise2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Input
		System.out.print("Input first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Input second number: ");
		int num2 = scanner.nextInt();
		
		// Calculate
		int sum = num1 + num2;
        int subtract = num1 - num2;
        int multiply = num1 * num2;
        int divide = num1 / num2;
        int remainder = num1 % num2;
        
        // Print out
        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + subtract);
        System.out.println(num1 + " x " + num2 + " = " + multiply);
        System.out.println(num1 + " / " + num2 + " = " + divide);
        System.out.println(num1 + " % " + num2 + " = " + remainder);

        scanner.close();
	}

}
