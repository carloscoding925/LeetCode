package Java.Easy;

import java.util.HashMap;
import java.util.Map;

public class _242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println("#242 - Valid Anagram - Easy");

        String stringOne = "anagram";
        String stringTwo = "nagaram";
        boolean areEqual = isAnagram(stringOne, stringTwo);
        System.out.println("Strings are Anagrams: " + areEqual);

        return;
    }

    private static boolean isAnagram(String s, String t) {
        Map<Character, Integer> stringOneMap = new HashMap<>();
        Map<Character, Integer> stringTwoMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);

            if (stringOneMap.containsKey(nextChar)) {
                stringOneMap.put(nextChar, stringOneMap.get(nextChar) + 1);
            }
            else {
                stringOneMap.put(nextChar, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char nextChar = t.charAt(j);

            if (stringTwoMap.containsKey(nextChar)) {
                stringTwoMap.put(nextChar, stringTwoMap.get(nextChar) + 1);
            }
            else {
                stringTwoMap.put(nextChar, 1);
            }
        }

        return stringOneMap.equals(stringTwoMap);
    }
    /*
     * Alternatively, use one hashmap to add first strings characters,
     * then remove second strings characters (and entry when count is 0)
     * and if hashmap is empty, it is a anagram
     */
}
