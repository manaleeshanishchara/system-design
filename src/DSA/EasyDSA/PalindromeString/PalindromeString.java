package DSA.EasyDSA.PalindromeString;

public class PalindromeString {

    static boolean isPalindrome(String str) {
        // TODO: write logic

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "manalee";
        System.out.println(str + " is palindrome? " + isPalindrome(str));
    }
}
