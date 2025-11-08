package Java.Easy;

import java.util.HashSet;
import java.util.Set;

public class _219_ContainsDuplicateTwo {
    public static void main(String[] args) {
        System.out.println("#219 - Contains Duplicate 2 - Easy");

        int[] input = {1, 2, 3, 1, 2, 3};
        int target = 2;

        boolean contains = containsNearbyDuplicate(input, target);
        System.out.println("Contains Duplicate Within " + target + " Distance: " + contains);

        return;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}
