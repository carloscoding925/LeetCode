package Java.Easy;

public class _70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("#70 - Climbing Stairs - Easy");

        int height = 3;
        int uniqueWays = climbStairs(height);

        System.out.println("There are " + uniqueWays + " ways to climb " + height + " steps");

        return;
    }

    private static int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
