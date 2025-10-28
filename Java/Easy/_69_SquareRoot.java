package Java.Easy;

public class _69_SquareRoot {
    public static void main(String[] args) {
        System.out.println("#69 - Square Root - Easy");

        int input = 16;
        int root = mySqrt(input);

        System.out.println("Square Root of " + input + " is " + root);

        return;
    }

    private static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            }
            else if (square < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return right;
    }
}
