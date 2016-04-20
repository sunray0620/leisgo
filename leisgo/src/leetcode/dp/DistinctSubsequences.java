package leetcode.dp;

/**
 * For leetcode problem #115: Distinct Subsequences.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        char[] tcs = t.toCharArray();
        char[] scs = s.toCharArray();
        int[][] dp = new int[scs.length + 1][tcs.length + 1];

        for (int i = 0; i <= scs.length; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= scs.length; ++i) {
            for (int j = 1; j <= tcs.length; ++j) {
                dp[i][j] = (scs[i - 1] == tcs[j - 1])? dp[i - 1][j - 1] + dp[i - 1][j] : dp[i - 1][j];
            }
        }
        return dp[scs.length][tcs.length];
    }
}
