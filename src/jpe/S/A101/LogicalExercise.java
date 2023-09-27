package jpe.S.A101;

import java.util.Scanner;

public class LogicalExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Input first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Input second integer: ");
        int num2 = scanner.nextInt();

        // Compare
        if (num1 != num2) {
            System.out.println(num1 + " != " + num2);
        } else {
            System.out.println(num1 + " == " + num2);
        }

        if (num1 < num2) {
            System.out.println(num1 + " < " + num2);
        } else if (num1 > num2) {
            System.out.println(num1 + " > " + num2);
        } else {
            System.out.println(num1 + " is equal to " + num2);
        }

        if (num1 <= num2) {
            System.out.println(num1 + " <= " + num2);
        } else {
            System.out.println(num1 + " > " + num2);
        }

        scanner.close();
    }
}