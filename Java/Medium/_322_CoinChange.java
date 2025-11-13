package Java.Medium;

import java.util.Arrays;

public class _322_CoinChange {
    public static void main(String[] args) {
        System.out.println("#322 - Coin Change - Medium");

        int amount = 11;
        int[] coins = {1, 2, 5};

        int fewest = coinChange(coins, amount);
        System.out.println("Fewest Amount of Coins Needed: " + fewest);
        
        return;
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
