package DSA.EasyDSA.LinearSearch;

import java.util.Objects;

public class LinearSearch {

    static int linearSearch(int[] arr, int target) {
        Objects.requireNonNull(arr, "arr must not be null");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 8, 2, 6, 1 };

        System.out.println("Index of 6 = " + linearSearch(arr, 6));   // 3
        System.out.println("Index of 10 = " + linearSearch(arr, 10)); // -1

        try {
            linearSearch(null, 6);
        } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
