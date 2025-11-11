package Java.Hard;

import java.util.HashMap;
import java.util.Map;

public class _76_MinWindowSubstring {
    public static void main(String[] args) {
        System.out.println("#76 - Minimum Window Substring - Hard");

        String one = "ADOBECODEBANC";
        String two = "ABC";

        String min = minWindow(one, two);
        System.out.println("Minimum Window Substring: " + min);

        return;
    }

    private static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int required = targetMap.size();
        int formed = 0;

        Map<Character, Integer> windowMap = new HashMap<>();
        int[] result = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
