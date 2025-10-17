package Java.Easy;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("#217 - Contains Duplicate - Easy");

        int[] numsArray = {1, 2, 3, 1};
        boolean isDistinct = containsDuplicate(numsArray);
        System.out.println("Array Contains Duplicate? " + isDistinct);

        return;
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                return true;
            }
            else {
                numsSet.add(nums[i]);
            }
        }

        return false;
    }
}
