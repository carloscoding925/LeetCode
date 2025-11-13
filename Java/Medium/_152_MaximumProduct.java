package Java.Medium;

public class _152_MaximumProduct {
    public static void main(String[] args) {
        System.out.println("#152 - Maximum Product Subarray - Medium");

        int[] nums = {2, 3, -2, 4};
        int product = maxProduct(nums);

        System.out.println("Max Product Found In Array: " + product);

        return;
    }

    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxProduct;

            maxProduct = Math.max(nums[i], Math.max(nums[i] * maxProduct, nums[i] * minProduct));
            minProduct = Math.min(nums[i], Math.min(nums[i] * minProduct, nums[i] * tempMax));

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
