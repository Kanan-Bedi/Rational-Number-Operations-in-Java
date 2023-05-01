import java.util.InputMismatchException;
import java.util.Scanner;


class RationalNumber {
    private int numerator; 
    private int denominator; 

    
    public RationalNumber(int numerator, int denominator) {
            if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); 
    }


    public RationalNumber add(RationalNumber other) {
        int resultNumerator = this.numerator * other.denominator + other.numerator * this.denominator; 
        int resultDenominator = this.denominator * other.denominator; 
        return new RationalNumber(resultNumerator, resultDenominator); 
    }

    public RationalNumber subtract(RationalNumber other) {
        int resultNumerator = this.numerator * other.denominator - other.numerator * this.denominator; 
        int resultDenominator = this.denominator * other.denominator; 
        return new RationalNumber(resultNumerator, resultDenominator); 
    }

    
    public RationalNumber multiply(RationalNumber other) {
        int resultNumerator = this.numerator * other.numerator; 
        int resultDenominator = this.denominator * other.denominator; 
        return new RationalNumber(resultNumerator, resultDenominator); 
    }

    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        int resultNumerator = this.numerator * other.denominator; 
        int resultDenominator = this.denominator * other.numerator; 
        return new RationalNumber(resultNumerator, resultDenominator); 
    }

    public boolean equals(RationalNumber other) {
        return this.numerator == other.numerator && this.denominator == other.denominator; 
    }

    public double toDouble() {
        return (double) this.numerator / this.denominator; 
    }

    public RationalNumber abs() {
        int absNumerator = Math.abs(this.numerator); 
        int absDenominator = Math.abs(this.denominator); 
        return new RationalNumber(absNumerator, absDenominator); 
    }
    private void simplify() { 
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator; 
    }
}
