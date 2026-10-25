package DSA.EasyDSA.FindMaxInArray;

public class FindMaxInArray {

    static int findMax(int[] arr) {
        // TODO: write logic
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 7, 1, 19, 4 };
        System.out.println("Max = " + findMax(arr));
    }
}
