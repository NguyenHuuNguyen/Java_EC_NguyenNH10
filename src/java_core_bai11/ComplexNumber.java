package java_core_bai11;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber() {
    	
    }

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public void inputComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public void displayComplexNumber() {
        System.out.println(realPart + " + " + imaginaryPart + "i");
    }

    public ComplexNumber addTwoComplexNumbers(ComplexNumber other) {
        double newRealPart = this.realPart + other.realPart;
        double newImaginaryPart = this.imaginaryPart + other.imaginaryPart;
        return new ComplexNumber(newRealPart, newImaginaryPart);
    }

    public ComplexNumber multiplyTwoComplexNumbers(ComplexNumber other) {
        double newRealPart = (this.realPart * other.realPart) - (this.imaginaryPart * other.imaginaryPart);
        double newImaginaryPart = (this.realPart * other.imaginaryPart) + (this.imaginaryPart * other.realPart);
        return new ComplexNumber(newRealPart, newImaginaryPart);
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
}