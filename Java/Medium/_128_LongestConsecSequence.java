package Java.Medium;

import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecSequence {
    public static void main(String[] args) {
        System.out.println("#128 - Longest Consecutive Sequence - Medium");

        int[] input = {100, 4, 200, 1, 3, 2};
        int lcs = longestConsecutive(input);

        System.out.println("Longest Consecutive Sequence: " + lcs);

        return;
    }

    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int maxLength = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
