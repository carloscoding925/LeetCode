package Java.Easy;

import java.util.Arrays;

public class _338_CountingBits {
    public static void main(String[] args) {
        System.out.println("#338 - Counting Bits - Easy");

        int num = 5;
        int[] bitNum = countBits(num);

        System.out.println("Number of bits per entry: " + Arrays.toString(bitNum));

        return;
    }

    private static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
