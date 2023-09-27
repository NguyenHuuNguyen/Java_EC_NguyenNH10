package java_core_bai11;

public class Main {

	public static void main(String[] args) {
        ComplexNumber complex1 = new ComplexNumber();
        complex1.inputComplexNumber(3.0, 2.0);

        ComplexNumber complex2 = new ComplexNumber(1.5, 4.0);

        System.out.println("Complex Number 1:");
        complex1.displayComplexNumber();

        System.out.println("Complex Number 2:");
        complex2.displayComplexNumber();

        // Add two complex numbers
        ComplexNumber sum = complex1.addTwoComplexNumbers(complex2);
        System.out.println("Sum of Complex Numbers:");
        sum.displayComplexNumber();

        // Multiply two complex numbers
        ComplexNumber multiply = complex1.multiplyTwoComplexNumbers(complex2);
        System.out.println("Multiply of Complex Numbers:");
        multiply.displayComplexNumber();

        // Modify and display complex1
        complex1.setRealPart(4.0);
        complex1.setImaginaryPart(3.0);
        System.out.println("Modified Complex Number 1:");
        complex1.displayComplexNumber();
    }

}
