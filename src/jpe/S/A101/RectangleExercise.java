package jpe.S.A101;

import java.util.Scanner;

public class RectangleExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();
        System.out.print("Enter the height of the rectangle: ");
        double height = scanner.nextDouble();

        // Calculate 
        double area = width * height;
        double perimeter = 2 * (width + height);

        // Print out
        System.out.println("Area is " + width + " * " + height + " = " + area);
        System.out.println("Perimeter is 2 * (" + width + " + " + height + ") = " + perimeter);

        scanner.close();
    }
}
