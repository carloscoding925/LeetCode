package Java.Easy;

public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("#14 - Longest Common Prefix - Easy");

        String[] stringArray = {"flower", "flow", "flight"};
        String lcp = longestCommonPrefix(stringArray);
        System.out.println("Longest Common Prefix is: " + lcp);
        lcp = optimizedSolution(stringArray);

        return;
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String lcp = strs[0];

        for (String nextString : strs) {
            int lcpLength = lcp.length();
            int nextStringLength = nextString.length();
            int iterator = 0;
            StringBuilder temp = new StringBuilder();

            while (iterator < lcpLength && iterator < nextStringLength) {
                if (lcp.charAt(iterator) == nextString.charAt(iterator)) {
                    temp.append(lcp.charAt(iterator));
                    iterator++;
                }
                else {
                    break;
                }
            }

            lcp = temp.toString();
        }

        return lcp;
    }

    private static String optimizedSolution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
