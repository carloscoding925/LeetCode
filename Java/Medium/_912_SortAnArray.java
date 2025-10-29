package Java.Medium;

import java.util.Arrays;

public class _912_SortAnArray {
    public static void main(String[] args) {
        System.out.println("#912 - Sort an Array - Medium");

        int[] input = {5, 1, 1, 2, 0, 0};
        int[] input2 = {5, 1, 1, 2, 0, 0};

        int[] sorted = sortArray(input);
        int[] sorted2 = sortArrayWithHeap(input2);

        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(sorted2));

        return;
    }

    private static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = medianOfThree(nums, left, mid, right);

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;
    }

    private static int medianOfThree(int[] nums, int left, int mid, int right) {
        if (nums[left] > nums[mid]) swap(nums, left, mid);
        if (nums[mid] > nums[right]) swap(nums, mid, right);
        if (nums[left] > nums[mid]) swap(nums, left, mid);

        swap(nums, mid, right);
        return nums[right];
    }

    private static int[] sortArrayWithHeap(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }

        return nums;
    }

    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
