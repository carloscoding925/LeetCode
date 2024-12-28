public class TwoSum_1{
    static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int complement = target - currentNumber;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        System.out.println("#1 - Two Sum - Easy");

        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}