package DSA.EasyDSA.PrimeCheck;

public class PrimeCheck {

    static boolean isPrime(int n) {
        // TODO: write logic

        if (n <= 1)
            return false;
        if (n <= 3)
            return true; // 2 and 3
        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= n / i; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println(n + " is prime? " + isPrime(n));
    }
}
