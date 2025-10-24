package Java.Easy;

public class _680_ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println("#680 - Valid Palindrome 2 - Easy");

        String input = "abca";
        boolean isValid = validPalindrome(input);

        System.out.println("Is Valid Palindrome with Ability to Delete 1 Char: " + isValid);

        return;
    }

    private static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                boolean validSubstring = (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1));
                return validSubstring;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
