package Java.Hard;

public class _41_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("#41 - First Missing Positive - Hard");

        int[] input = {7, 8, 9, 11, 12};
        int first = firstMissingPositive(input);

        System.out.println("First Missing Positive: " + first);

        return;
    }

    private static int firstMissingPositive(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0 || nums[i] > length) {
                nums[i] = length + 1;
            }
        }

        for (int i = 0; i < length; i++) {
            int val = Math.abs(nums[i]);
            if (val <= length) {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return length + 1;
    }
}
