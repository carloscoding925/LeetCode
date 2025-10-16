package Java.Easy;

public class _1929_ArrayConcatenation {
    public static void main(String[] args) {
        System.out.println("#1929 - Concatenation of Array - Easy");

        int[] numsArray = {1, 2, 3};
        int[] result = getConcatenation(numsArray);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        return;
    }

    private static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] concatenated = new int[length * 2];

        for (int i = 0; i < length; i++) {
            concatenated[i] = nums[i];
            concatenated[length + i] = nums[i];
        }

        return concatenated;
    }
}
