package leetcode.dp;

/**
 * For leetcode problem 322: Coin change.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dptb = new int[amount + 1];
        for(int i = 0; i <= amount; ++i) {
            dptb[i] = -1;
        }
        dptb[0] = 0;
        for (int i = 0; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (dptb[i] != -1 && i + coins[j] <= amount && (dptb[i] + 1 < dptb[i + coins[j]] || dptb[i + coins[j]] == -1)) {
                    dptb[i + coins[j]] = dptb[i] + 1;
                }
            }
        }
        return dptb[amount];
    }
}
