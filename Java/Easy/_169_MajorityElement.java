package Java.Easy;

import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {
    public static void main(String[] args) {
        System.out.println("#169 - Majority Element - Easy");

        int[] inputArray = {2, 2, 1, 1, 1, 2, 2};
        int majority = majorityElement(inputArray);

        System.out.println("Majority Element in array is: " + majority);

        int optimalSolution = mooresVotingAlgorithm(inputArray);
        System.out.println("Using Optimal Solution: " + optimalSolution);

        return;
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        final int half = nums.length / 2;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            if (!frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], 1);
            }
            else {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
                if (frequencyMap.get(nums[i]) > half) {
                    return nums[i];
                }
            }
        }

        return -1;
    }

    private static int mooresVotingAlgorithm(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        return candidate;
    }
}
