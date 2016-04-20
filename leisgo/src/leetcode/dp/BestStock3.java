package leetcode.dp;

/**
 * For leetcode problem #123: Best time to buy and sell stock III
 */
public class BestStock3 {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int maxProfit = 0;
        int[] prft1 = new int[prices.length];
        for (int i = 0; i < prices.length; ++i) {
            lowest = Math.min(lowest, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
            prft1[i] = maxProfit;
        }

        int highest = Integer.MIN_VALUE;
        maxProfit = 0;
        int[] prft2 = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; --i) {
            highest = Math.max(highest, prices[i]);
            maxProfit = Math.max(maxProfit, highest - prices[i]);
            prft2[i] = maxProfit;
        }

        maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            int profit1 = prft1[i];
            int profit2 = (i + 1 >= prices.length)? 0 : prft2[i];
            maxProfit = Math.max(maxProfit, profit1 + profit2);
        }
        return maxProfit;
    }
}
