package Java.Easy;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    public static void main(String[] args) {
        System.out.println("#1 - Two Sum - Easy");

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result[0] == 0 && result[1] == 0) {
            System.out.println("No solution found");
            return;
        }

        System.out.println("Numbers that add up to: " + target + " found at indices: " + result[0] + " and " + result[1]);
        return;
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (complementsMap.containsKey(complement)) {
                return new int[] {complementsMap.get(complement), i};
            }
            else {
                complementsMap.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}
