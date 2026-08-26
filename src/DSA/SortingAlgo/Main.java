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

        int[] quickResult = Arrays.copyOf(data, data.length);
        QuickSort.quickSort(quickResult, 0, quickResult.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickResult));

        int[] mergeResult = Arrays.copyOf(data, data.length);
        MergeSort.mergeSort(mergeResult, 0, mergeResult.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeResult));
    }
}

// swapping element s until bigger reach to largest postion
// In-place: Yes | Stable: Yes | Time: O(n^2) worst/avg, O(n) best | Space: O(1)
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
// In-place: Yes | Stable: Yes | Time: O(n^2) worst/avg, O(n) best | Space: O(1)
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
// In-place: Yes | Stable: No | Time: O(n^2) worst/avg/best | Space: O(1)
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

// In-place: Yes | Stable: No | Time: O(n log n) avg/best, O(n^2) worst | Space: O(log n) recursion stack
class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }
}

// In-place: No | Stable: Yes | Time: O(n log n) worst/avg/best | Space: O(n) auxiliary arrays
class MergeSort {
    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);

        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}