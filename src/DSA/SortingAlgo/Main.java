package DSA.SortingAlgo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = { 5, 2, 9, 1, 5, 6 };

        int[] bubbleResult = Arrays.copyOf(data, data.length);
        BubbleSort.sort(bubbleResult);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleResult));

        int[] insertionResult = Arrays.copyOf(data, data.length);
        InsertionSort.sort(insertionResult);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionResult));

        int[] selectionResult = Arrays.copyOf(data, data.length);
        SelectionSort.sort(selectionResult);
        System.out.println("Selection Sort: " + Arrays.toString(selectionResult));
    }
}

// swapping element s until bigger reach to largest postion
class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}

// hole algorithm
class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

// select minmum and put it to ith index
class SelectionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
