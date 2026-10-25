package DSA.EasyDSA.ReverseNumber;

public class ReverseNumber {

    static int reverse(int n) {
        // TODO: write logic

        int reversed = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            reversed = reversed * 10 + lastDigit;
            n = n / 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Reverse of " + n + " = " + reverse(n));
    }
}
