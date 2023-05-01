public class Main {
    public static void main(String[] args) {
        try {
            int numerator1 = Integer.parseInt(args[0]);
            int denominator1 = Integer.parseInt(args[1]);
            RationalNumber rational1 = new RationalNumber(numerator1, denominator1);

            int numerator2 = Integer.parseInt(args[2]);
            int denominator2 = Integer.parseInt(args[3]);
            RationalNumber rational2 = new RationalNumber(numerator2, denominator2);

            System.out.println("Rational 1 = " + rational1); 
            System.out.println("Rational 2 = " + rational2); 

            RationalNumber result = rational1.add(rational2);
            System.out.println("Addition: " + rational1 + " + " + rational2 + " = " + result); //Add
            result = rational1.subtract(rational2);
            System.out.println("Subtraction: " + rational1 + " - " + rational2 + " = " + result); //Subtract
            result = rational1.multiply(rational2);
            System.out.println("Multiplication: " + rational1 + " * " + rational2 + " = " + result); // Multiply

            try {
                result = rational1.divide(rational2);
                System.out.println("Division: " + rational1 + " / " + rational2 + " = " + result);  // Division
            } catch (ArithmeticException e) {
                System.out.println("Division error: " + e.getMessage());
            }

            boolean isEqual = rational1.equals(rational2);
            System.out.println("Equality check: " + rational1 + " = " + rational2 + " is " + isEqual);

            double doubleValue1 = rational1.toDouble();
            double doubleValue2 = rational2.toDouble();
            System.out.println("Floating point conversion: " + rational1 + " = " + doubleValue1 + ", " + rational2 + " = " + doubleValue2);

            result = rational1.abs();
            System.out.println("Absolute value: |" + rational1 + "| = " + result); // abs
        } catch (NumberFormatException e) {
            System.out.println("Input error: " + e.getMessage() + ". Please enter integers as input.");
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage()); // Throwing Error
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java Main <numerator1> <denominator1> <numerator2> <denominator2>");
        }
    }
}
