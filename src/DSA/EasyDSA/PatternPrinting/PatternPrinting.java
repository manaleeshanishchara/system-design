package DSA.EasyDSA.PatternPrinting;

public class PatternPrinting {

    // Pattern 1
    static void printPattern1(int n) {
        // TODO: write logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pattern 2
    static void printPattern2(int n) {
        // TODO: write logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Pattern 1:");
        printPattern1(n);
        System.out.println("Pattern 2:");
        printPattern2(n);
    }
}
