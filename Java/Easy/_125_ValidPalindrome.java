package Java.Easy;

public class _125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("#125 - Valid Palindrome - Easy");

        String input = "A man, a plan, a canal: Panama";
        boolean isValid = isPalindrome(input);

        System.out.println("Is Palindrome: " + isValid);

        return;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while((left < right) && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while((left < right) && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
