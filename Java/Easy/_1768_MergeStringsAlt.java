package Java.Easy;

public class _1768_MergeStringsAlt {
    public static void main(String[] args) {
        System.out.println("#1768 - Merge Strings Alternately - Easy");

        String first = "abc";
        String second = "pqrt";
        String result = mergeAlternately(first, second);

        System.out.println("Result of Merged Strings: " + result);

        return;
    }

    private static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int word1Pointer = 0;
        int word2Pointer = 0;

        while (word1Pointer < word1.length() || word2Pointer < word2.length()) {
            if (word1Pointer < word1.length()) {
                builder.append(word1.charAt(word1Pointer));
                word1Pointer++;
            }

            if (word2Pointer < word2.length()) {
                builder.append(word2.charAt(word2Pointer));
                word2Pointer++;
            }
        }

        return builder.toString();
    }
}
