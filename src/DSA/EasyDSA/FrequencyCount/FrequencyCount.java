package DSA.EasyDSA.FrequencyCount;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {

    static void countFrequency(int[] arr) {
        // TODO: write logic
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int val : arr) {
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        }

        System.out.println(frequencyMap);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 1, 4, 2 };
        countFrequency(arr);
    }
}
