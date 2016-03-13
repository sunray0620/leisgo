package leetcode;

/**
 * For leetcode problem 279 - perfect squares.
 * Created by sunlei on 3/12/16.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        // Find the number of coins we need.
        int numOfCoins = 1;
        for(int i = 0; i < 65535; ++i) {
            if (i * i <= n) {
                numOfCoins = i;
            } else {
                break;
            }
        }

        // Initialize coin values.
        int[] coins = new int[numOfCoins];
        for(int i = 0; i < numOfCoins; ++i) {
            coins[i] = (i + 1) * (i + 1);
        }

        // Fill max value for initialization.
        int[] wt = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            wt[i] = Integer.MAX_VALUE;
        }

        // Dynamic programming.
        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0 && wt[i - coins[j]] + 1 < wt[i]) {
                    wt[i] = wt[i - coins[j]] + 1;
                }
            }
        }
        return wt[n];
    }
}
