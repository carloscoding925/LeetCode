import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    // Brute Force Method
    static int[] solutionOne(int[] nums, int target) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(i == j) {
                    continue;
                }
                else if (nums[i] + nums [j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {0, 0};
    }

    // Hashmap Method
    static int[] solutionTwo(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++){
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[] {numsMap.get(complement), i};
            }
            else {
                numsMap.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
    public static void main(String[] args) {
        System.out.println("#1 - Two Sum - Easy");
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solutionTwo(nums, target);
        System.out.println("Result: " + result[0] + ", " + result[1]);
    }
}