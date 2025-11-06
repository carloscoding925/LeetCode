package Java.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _347_KFrequentElements {
    public static void main(String[] args) {
        System.out.println("#347 - Top K Frequent Elements - Medium");

        int[] input = {1, 1, 1, 2, 2, 3};
        int[] mostFrequent = topKFrequent(input, 2);

        System.out.println("Top 2 Most Frequent Elements: " + Arrays.toString(mostFrequent));

        return;
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], 1);
            }
            else {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            }
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
