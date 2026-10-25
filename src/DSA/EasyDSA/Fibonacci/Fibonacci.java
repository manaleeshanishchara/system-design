package DSA.EasyDSA.Fibonacci;

public class Fibonacci {

    static void printFibonacci(int n) {
        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int temp = first + second;
            first = second;
            second = temp;
        }
        // TODO: write logic
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacci(n);
        System.out.println("");
        printFibonacci(0);
        System.out.println("");
        printFibonacci(1);
        System.out.println("");
        printFibonacci(2);
        System.out.println("");
        printFibonacci(3);
    }
}
