package Java.Medium;

public class _371_SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println("#371 - Sum of Two Integers - Medium");

        int one = 2;
        int two = 3;

        int sum = getSum(one, two);
        System.out.println("Sum using bitwise operations: " + sum);

        return;
    }

    private static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
