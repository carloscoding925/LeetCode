package Java.Medium;

import java.util.HashMap;
import java.util.Map;

public class _560_SubSumEqualsK {
    public static void main(String[] args) {
        System.out.println("#560 - Subarray Sum Equals K - Medium");

        int[] input = {1, 2, 3};
        int k = 3;
        int totalSubarrays = subArraySum(input, k);

        System.out.println("Total Sub Arrays that add up to " + k + ": " + totalSubarrays);

        return;
    }

    private static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        frequencyMap.put(0, 1);

        int cumulativeSum = 0;
        int count = 0;

        for (int num : nums) {
            cumulativeSum += num;

            if (frequencyMap.containsKey(cumulativeSum - k)) {
                count += frequencyMap.get(cumulativeSum - k);
            }

            frequencyMap.put(cumulativeSum, frequencyMap.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
