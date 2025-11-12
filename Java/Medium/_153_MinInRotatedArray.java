package Java.Medium;

public class _153_MinInRotatedArray {
    public static void main(String[] args) {
        System.out.println("#153 - Find Minimum in Rotated Sorted Array - Medium");

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int targetMin = findMin(nums);

        System.out.println("Minimum Element in Array: " + targetMin);

        return;
    }

    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}
