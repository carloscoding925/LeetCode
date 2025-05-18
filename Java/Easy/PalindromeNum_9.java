public class PalindromeNum_9 {
    private static boolean isPalindrome(int x) {
        String integerString = Integer.toString(x);
        int length = integerString.length();
        int midPoint = length / 2;

        for (int i = 0; i < midPoint; i++) {
            if (integerString.charAt(i) != integerString.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("#9 - Palindrome Number - Easy");
        boolean result = isPalindrome(125521);

        System.out.println("Is Palindrome: " + result);
    }
}
