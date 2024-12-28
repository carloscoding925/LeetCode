public class TwoSum_1{
    static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; i++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
                else {
                    continue;
                }
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        System.out.println("#1 - Two Sum - Easy");

        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}