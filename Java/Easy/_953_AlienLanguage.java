package Java.Easy;

import java.util.HashMap;
import java.util.Map;

public class _953_AlienLanguage {
    public static void main(String[] args) {
        System.out.println("#953 - Verifying an Alien Dictionary - Easy");

        String[] input = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean isSorted = isAlienSorted(input, order);
        System.out.println("Is Sorted: " + isSorted);

        return;
    }

    private static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int j = 0; j < words.length - 1; j++) {
            String word1 = words[j];
            String word2 = words[j + 1];

            int minLength = Math.min(word1.length(), word2.length());
            boolean foundDiff = false;

            for (int k = 0; k < minLength; k++) {
                int char1 = orderMap.get(word1.charAt(k));
                int char2 = orderMap.get(word2.charAt(k));

                if (char1 < char2) {
                    foundDiff = true;
                    break;
                }
                else if (char1 > char2) {
                    return false;
                }
            }

            if (!foundDiff && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}
