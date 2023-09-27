package jpe.S.A101;

import java.util.Scanner;

public class CircleExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Calculate
        double perimeter = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        // Print out
        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);

        scanner.close();
    }
}