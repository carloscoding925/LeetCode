package Java.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {
    public static void main(String[] args) {
        System.out.println("#139 - Word Break - Medium");

        String input = "applepenapple";
        List<String> dictionary = new ArrayList<>(Arrays.asList("apple", "pen"));

        boolean canBeSegmented = wordBreak(input, dictionary);

        System.out.println("Word can be segmented: " + canBeSegmented);

        return;
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
