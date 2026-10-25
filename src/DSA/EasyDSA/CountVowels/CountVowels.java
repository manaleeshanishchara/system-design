package DSA.EasyDSA.CountVowels;

public class CountVowels {

    static int countVowels(String str) {
        // TODO: write logic

        int vovelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                vovelCount++;
            }
        }

        return vovelCount;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Vowels in \"" + str + "\" = " + countVowels(str));
    }
}
