package Java.Medium;

public class _424_LongestCharacterRep {
    public static void main(String[] args) {
        System.out.println("#424 - Longest Repeating Character Replacement - Medium");

        String input = "AABABBA";
        int val = 1;

        int longest = characterReplacement(input, val);
        System.out.println("Longest Repeating Substring with Character Replacement: " + longest);

        return;
    }

    private static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar - 'A']++;

            maxFreq = Math.max(maxFreq, count[rightChar - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
