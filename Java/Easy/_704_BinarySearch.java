package Java.Easy;

public class _704_BinarySearch {
    public static void main(String[] args) {
        System.out.println("#704 - Binary Search - Java");

        int[] input = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println("Index of Target: " + search(input, target));
    }

    private static int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer <= rightPointer) {
            int mid = (rightPointer + leftPointer) / 2;

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

        return -1;
    }
}
