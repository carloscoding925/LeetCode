package Java.Medium;

import java.util.ArrayList;
import java.util.Arrays;
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
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String nextString : strs) {
            char[] charArray = nextString.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (anagramsMap.containsKey(sortedString)) {
                List<String> anagramsList = anagramsMap.get(sortedString);
                anagramsList.add(nextString);
                anagramsMap.put(sortedString, anagramsList);
            }
            else {
                List<String> newList = new ArrayList<>(List.of(nextString));
                anagramsMap.put(sortedString, newList);
            }
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
