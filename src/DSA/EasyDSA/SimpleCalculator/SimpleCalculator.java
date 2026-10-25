package DSA.EasyDSA.SimpleCalculator;

public class SimpleCalculator {

    static double calculate(double a, double b, char operator) {
        // TODO: write logic

        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("Error: Division by zero");
                    return Double.NaN; // Return NaN for division by zero
                }
            default:
                System.out.println("Error: Invalid operator");
        }

        return 0;
    }

    public static void main(String[] args) {
        double a = 10, b = 5;
        System.out.println(a + " + " + b + " = " + calculate(a, b, '+'));
        System.out.println(a + " - " + b + " = " + calculate(a, b, '-'));
        System.out.println(a + " * " + b + " = " + calculate(a, b, '*'));
        System.out.println(a + " / " + b + " = " + calculate(a, b, '/'));
    }
}
