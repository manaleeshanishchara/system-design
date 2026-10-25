package DSA.EasyDSA.SortFiveNumbers;

import java.util.Arrays;

public class SortFiveNumbers {

    static void sort(int[] arr) {
        // TODO: write logic (manually, no Arrays.sort)

        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            System.out.println("In between:  " + Arrays.toString(arr));
            if (flag) {
                System.out.println("No swaps needed, array is sorted. break");
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = { 42, 7, 19, 3, 25 };
        System.out.println("Before: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }
}
