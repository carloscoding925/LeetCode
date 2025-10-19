package Java.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("#49 - Group Anagrams - Medium");

        String[] input = {"stop", "pots", "reed", "", "tops", "deer", "opts", ""};
        List<List<String>> result = groupAnagrams(input);

        System.out.println("Grouped Anagrams: " + result.toString());

        return;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return List.of();
        }

        List<List<String>> anagramList = new ArrayList<>();

        for (String nextString : strs) {
            if (anagramList.isEmpty()) {
                anagramList.add(new ArrayList<>(List.of(nextString)));
                continue;
            }

            Map<Character, Integer> nextStringMap = new HashMap<>();
            int i = 0;

            while (i < nextString.length()) {
                if (nextStringMap.containsKey(nextString.charAt(i))) {
                    nextStringMap.put(nextString.charAt(i), nextStringMap.get(nextString.charAt(i)) + 1);
                }
                else {
                    nextStringMap.put(nextString.charAt(i), 1);
                }
                i++;
            }

            boolean isAnagram = false;

            for (int k = 0; k < anagramList.size(); k++) {
                if (isAnagram) { continue; }

                Map<Character, Integer> copyMap = new HashMap<>(nextStringMap);
                List<String> anagrams = anagramList.get(k);
                String existingAnagram = anagrams.get(0);
                int j = 0;

                while (j < existingAnagram.length()) {
                    if (copyMap.containsKey(existingAnagram.charAt(j))) {
                        copyMap.put(existingAnagram.charAt(j), copyMap.get(existingAnagram.charAt(j)) - 1);

                        if (copyMap.get(existingAnagram.charAt(j)) == 0) {
                            copyMap.remove(existingAnagram.charAt(j));
                        }
                    }
                    else {
                        break;
                    }
                    j++;
                }

                if (copyMap.isEmpty() && nextString.length() != 0) {
                    isAnagram = true;
                    anagramList.get(k).addLast(nextString);
                }

                if (copyMap.isEmpty() && existingAnagram.length() == 0) {
                    isAnagram = true;
                    anagramList.get(k).addLast(nextString);
                }
            }

            if (!isAnagram) {
                anagramList.add(new ArrayList<>(List.of(nextString)));
            }
        }

        return anagramList;
    }
}
