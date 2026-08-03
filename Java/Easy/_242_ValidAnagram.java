// Attempts (2)
// Last Attempted - August 2nd, 2026

package Java.Easy;

import java.util.HashMap;
import java.util.Map;

public class _242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println("#242 - Valid Anagram - Easy");

        String inputOne = "anagram";
        String inputTwo = "nagaram";

        boolean areTheyAnagrams = isAnagram(inputOne, inputTwo);

        System.out.printf("Are %s and %s anagrams: %b", inputOne, inputTwo, areTheyAnagrams);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> stringMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            stringMap.put(s.charAt(i), stringMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            stringMap.put(t.charAt(i), stringMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        return stringMap.values().stream().allMatch(x -> x == 0);
    }
}
