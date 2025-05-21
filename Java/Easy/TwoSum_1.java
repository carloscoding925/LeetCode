import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    private static int[] solution(int[] nums, int target) {
        int[] indices = {0, 0};
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementMap.containsKey(complement)) {
                indices[0] = complementMap.get(complement);
                indices[1] = i;
                return indices;
            }
            else {
                complementMap.put(nums[i], i);
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        System.out.println("#1 - Two Sum - Easy");

        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = solution(nums, target);
        System.out.println("Result: [" + result[0] + "], [" + result[1] + "]");
    }
}