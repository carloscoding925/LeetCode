package Java.Medium;

public class _55_JumpGame {
    public static void main(String[] args) {
        System.out.println("#55 - Jump Game");

        int[] input = {2, 3, 1, 1, 4};
        boolean canMakeIt = canJump(input);

        System.out.println("Can Make the Jump: " + canMakeIt);

        return;
    }

    private static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
