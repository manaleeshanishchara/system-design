package DSA.SortingAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        int[] heapResult = Arrays.copyOf(data, data.length);
        HeapSort.sort(heapResult);
        System.out.println("Heap Sort: " + Arrays.toString(heapResult));

        int[] countingResult = Arrays.copyOf(data, data.length);
        CountingSort.sort(countingResult);
        System.out.println("Counting Sort: " + Arrays.toString(countingResult));

        int[] radixResult = Arrays.copyOf(data, data.length);
        RadixSort.sort(radixResult);
        System.out.println("Radix Sort: " + Arrays.toString(radixResult));

        int[] bucketResult = Arrays.copyOf(data, data.length);
        BucketSort.sort(bucketResult);
        System.out.println("Bucket Sort: " + Arrays.toString(bucketResult));
    }
}

/*
 * swapping element's until bigger reach to largest postion
 * In-place: Yes
 * Stable: Yes
 * Time: O(n^2) worst/avg, O(n) best
 * Space: O(1)
 */
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

/*
 * hole algorithm
 * In-place: Yes
 * Stable: Yes
 * Time: O(n^2) worst/avg, O(n) best
 * Space: O(1)
 */
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

/*
 * select minmum and put it to ith index
 * In-place: Yes
 * Stable: No
 * Time: O(n^2) worst/avg/best
 * Space: O(1)
 */
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

/*
 * In-place: Yes
 * Stable: No
 * Time: O(n log n) avg/best, O(n^2) worst
 * Space: O(log n) recursion stack
 */
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

/*
 * In-place: No
 * Stable: Yes
 * Time: O(n log n) worst/avg/best
 * Space: O(n) auxiliary arrays
 */
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

/*
 * In-place: Yes
 * Stable: No
 * Time: O(n log n) worst/avg/best
 * Space: O(1)
 */
class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int size, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest);
        }
    }
}

/*
 * In-place: No
 * Stable: Yes
 * Time: O(n + k) where k = value range
 * Space: O(n + k)
 * Works for any int range (handles negatives via a min offset), best when k is
 * not much larger than n.
 */
class CountingSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        int range = max - min + 1;
        int[] count = new int[range];
        for (int value : arr) {
            count[value - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            output[count[value - min] - 1] = value;
            count[value - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}

/*
 * In-place: No
 * Stable: Yes
 * Time: O(d * (n + b)) where d = digit count, b = base (10)
 * Space: O(n + b)
 * Assumes non-negative integers (LSD radix sort using counting sort per digit).
 */
class RadixSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int value : arr) {
            count[(value / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}

/*
 * In-place: No
 * Stable: Yes
 * Time: O(n + k) average, O(n^2) worst (all values in one bucket)
 * Space: O(n + k)
 * Distributes values across buckets by range, sorts each bucket, then
 * concatenates.
 */
class BucketSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        int bucketCount = arr.length;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        long range = (long) max - min + 1;
        for (int value : arr) {
            int bucketIndex = (int) ((long) (value - min) * bucketCount / range);
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1;
            }
            buckets.get(bucketIndex).add(value);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }
}