package Java.Easy;

public class _191_OneBits {
    public static void main(String[] args) {
        System.out.println("#191 - Number of 1 Bits - Easy");

        int n = 11;
        int weight = hammingWeight(n);

        System.out.println("Integer " + n + " has hamming weight: " + weight);

        return;
    }

    private static int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
