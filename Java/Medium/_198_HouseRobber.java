package Java.Medium;

public class _198_HouseRobber {
    public static void main(String[] args) {
        System.out.println("#198 - House Robber - Medium");

        int[] houses = {2, 7, 9, 3, 1};
        int maxMoney = rob(houses);

        System.out.println("Max Money to be Stolen: " + maxMoney);

        return;
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
