package Java.Easy;

public class _35_InsertPosition {
    public static void main(String[] args) {
        System.out.println("#35 - Search Insert Position - Easy");

        int[] input = {1, 3, 5, 6};
        int target = 3;
        int result = searchInsert(input, target);

        System.out.println("Result: " + result);

        return;
    }

    private static int searchInsert(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer <= rightPointer) {
            int mid = (leftPointer + rightPointer) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                leftPointer = mid + 1;
            }

            if (nums[mid] > target) {
                rightPointer = mid - 1;
            }
        }

        return leftPointer;
    }
}
