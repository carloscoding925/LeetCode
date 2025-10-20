package Java.Easy;

import java.util.Arrays;

public class _27_RemoveElement {
    public static void main(String[] args) {
        System.out.println("#27 - Remove Element - Easy");

        int[] numsArray = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        int remainingElements = removeElement(numsArray, target);

        System.out.println("Elements left after removing target: " + remainingElements + " Resulting Array: " + Arrays.toString(numsArray));

        return;
    }

    private static int removeElement(int[] nums, int val) {
        int nonTargetIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[nonTargetIndex] = nums[i];
                nonTargetIndex++;
            }
        }

        return nonTargetIndex;
    }
}
