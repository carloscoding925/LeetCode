// Attempts (2)
// Last Attempted - August 1st, 2026

package Java.Easy;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("#217 - Contains Duplicate - Easy");

        int[] hasDupe = {1, 2, 3, 1};
        int[] noDupe = {1, 2, 3, 4};

        boolean resultOne = containsDuplicate(hasDupe);
        boolean resultTwo = containsDuplicate(noDupe);

        System.out.println("First array has a duplicate: " + resultOne);
        System.out.println("Second array has a duplicate: " + resultTwo);
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            if (numsSet.contains(num)) {
                return true;
            }

            numsSet.add(num);
        }

        return false;
    }
}
