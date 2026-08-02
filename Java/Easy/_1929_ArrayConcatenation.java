// Attempts (2)
// Last Attempted - August 1st, 2026

package Java.Easy;

import java.util.Arrays;

public class _1929_ArrayConcatenation {
    public static void main(String[] args) {
        System.out.println("#1929 - Concatenation of Array - Easy");

        int[] input = {1, 2, 1};
        int[] concatenatedArray = getConcatenation(input);

        System.out.println("Concatenated Array: " + Arrays.toString(concatenatedArray));
    }

    private static int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size * 2];

        for (int i = 0; i < size; i++) {
            ans[i] = nums[i];
            ans[size + i] = nums[i];
        }

        return ans;
    }
}
