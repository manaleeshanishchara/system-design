package DSA.EasyDSA.AreaCalculator;

public class AreaCalculator {

    static double areaOfCircle(double radius) {
        // TODO: write logic
        return Math.PI * radius * radius;
    }

    static double areaOfRectangle(double length, double width) {
        // TODO: write logic

        return length * width;
    }

    static double areaOfTriangle(double base, double height) {
        // TODO: write logic
        return (base * height) / 2;
    }

    static double areaOfSquare(double side) {
        // TODO: write logic
        return side * side;
    }

    public static void main(String[] args) {
        System.out.println("Circle (r=7): " + String.format("%.2f", areaOfCircle(7)));
        System.out.println("Rectangle (4x6): " + areaOfRectangle(4, 6));
        System.out.println("Triangle (b=5, h=8): " + areaOfTriangle(5, 8));
        System.out.println("Square (s=5): " + areaOfSquare(5));
    }
}
