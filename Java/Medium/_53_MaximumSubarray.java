package Java.Medium;

public class _53_MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("#53 - Maximum Subarray - Medium");

        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(input);

        System.out.println("Sum of Max Subarray: " + maxSum);

        return;
    }

    private static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
