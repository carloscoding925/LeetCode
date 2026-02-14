package Java.Practice;

/*
    This file is for no particular question and you'll see it overwritten many times.
    I'll be using this as a practice file for whenever I want to re-attempt questions.
 */

public class Practice {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 9, 11};
        int target = 16;

        int result[] = twoSum(numbers, target);

        System.out.println("Target is composed of numbers in indices: " + result[0] + " and " + result[1]);

        return;
    }

    private static int[] twoSum(int[] nums, int target) {
        return new int[]{0, 0};
    }
}
