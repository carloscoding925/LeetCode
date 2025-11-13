package Java.Medium;

public class _213_HouseRobber2 {
    public static void main(String[] args) {
        System.out.println("#213 - House Robber II - Medium");

        int[] input = {1, 2, 3, 1};
        int maxMoney = rob(input);

        System.out.println("Maximum Money to Rob: " + maxMoney);

        return;
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int robFirstHouse = robLinear(nums, 0, nums.length - 2);
        int robLastHouse = robLinear(nums, 1, nums.length - 1);

        return Math.max(robFirstHouse, robLastHouse);
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
