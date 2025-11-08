package Java.Easy;

public class _121_BuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("#121 - Best Time to Buy and Sell Stock - Easy");

        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);

        System.out.println("Max Profit: " + profit);

        return;
    }

    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }

        return profit;
    }
}
