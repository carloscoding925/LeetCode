// Attempts (2)
// Last Attempted - August 2nd, 2026

package Java.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    public static void main(String[] args) {
        System.out.println("#1 - Two Sum - Easy");

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] results = twoSum(nums, target);

        System.out.println("Target value: " + target + " can be formed from numbers at indices: " + Arrays.toString(results));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer complement = complementsMap.get(target - nums[i]);

            if (complement != null) {
                return new int[] {i, complement.intValue()};
            }
            else {
                complementsMap.put(nums[i], i);
            }
        }

        throw new IllegalStateException("The twoSum method should always return a solution");
    }
}
