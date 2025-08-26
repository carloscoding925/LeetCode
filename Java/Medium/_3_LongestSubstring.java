package Java.Medium;

import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstring {
    public static void main(String[] args) {
        System.out.println("#3 - Longest Substrings Without Repeating Characters");

        String input = "abcabcbb";
        int longestSubstring = lengthOfLongestSubstring(input);

        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring);

        return;
    }

    private static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int leftPointer = 0;
        Set<Character> window = new HashSet<>();

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char nextCharacter = s.charAt(rightPointer);

            while (window.contains(nextCharacter)) {
                char previousChar = s.charAt(leftPointer);
                window.remove(previousChar);
                leftPointer++;
            }

            window.add(nextCharacter);
            longest = Math.max(longest, window.size());
        }
        
        return longest;
    }
}
