package Java.Easy;

public class _190_ReverseBits {
    public static void main(String[] args) {
        System.out.println("#190 - Reverse Bits - Easy");

        int input = 43261596;
        int reversed = reverseBits(input);

        System.out.println("Original: " + input + " Reversed: " + reversed);

        return;
    }

    private static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1;

            result = result | (n & 1);

            n = n >> 1;
        }

        return result;
    }
}
