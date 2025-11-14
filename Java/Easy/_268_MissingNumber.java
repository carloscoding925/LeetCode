package Java.Easy;

public class _268_MissingNumber {
    public static void main(String[] args) {
        System.out.println("#268 - Missing Number - Easy");

        int[] input = {3, 0, 1};
        int missingNum = missingNumber(input);

        System.out.println("Missing Number: " + missingNum);

        return;
    }

    private static int missingNumber(int[] nums) {
        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor;
    }
}
