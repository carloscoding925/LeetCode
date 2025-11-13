package Java.Medium;

public class _300_IncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println("#300 - Longest Increasing Subsequence - Medium");

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lis = lengthOfLIS(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + lis);

        return;
    }

    private static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int left = 0;
            int right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;
                
                if (tails[mid] < num) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }

            tails[left] = num;

            if (left == size) {
                size++;
            }
        }

        return size;
    }
}
