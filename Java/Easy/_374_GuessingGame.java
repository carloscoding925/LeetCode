package Java.Easy;

public class _374_GuessingGame {
    public static void main(String[] args) {
        System.out.println("#374 - Guess Number Higher or Lower - Easy");

        System.out.println("Chosen Number: " + guessNumber(10));

        return;
    }

    private static int guessNumber(int n) {
        int leftPointer = 0;
        int rightPointer = n;
        int mid = 0;

        while (leftPointer <= rightPointer) {
            mid = leftPointer + (rightPointer - leftPointer) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            }

            if (result == 1) {
                leftPointer = mid + 1;
            }
            
            if (result == -1) {
                rightPointer = mid - 1;
            }
        }

        return -1;
    }

    private static int guess(int n) {
        final int target = 6;

        if (n == target) {
            return 0;
        }
        else if (n < target) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
