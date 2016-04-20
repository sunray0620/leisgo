package leetcode.dp;

/**
 * For leetcode problem #121: Best time to buy and sell stock.
 */
public class BestStock1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            lowest = Math.min(lowest, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
        }
        return maxProfit;
    }
}
