package Java.Medium;

public class _647_PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println("#647 - Palindromic Substrings - Medium");

        String input = "aaa";
        int substrings = countSubstrings(input);

        System.out.println("Number of Palindromic Substrings: " + substrings);

        return;
    }

    private static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
