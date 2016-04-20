package leetcode.dp;

/**
 * For leetcode problem #97: Interleaving String.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();
        if (cs1.length + cs2.length > cs3.length) {
            return false;
        }

        boolean[][] dp = new boolean[cs1.length + 1][cs2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= cs1.length && cs1[i - 1] == cs3[i - 1]; ++i) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= cs2.length && cs2[j - 1] == cs3[j - 1]; ++j) {
            dp[0][j] = true;
        }

        for (int i = 1; i < cs1.length; ++i) {
            for (int j = 1; j < cs2.length; ++j) {
                dp[i][j] |= (cs3[i + j - 2] == cs2[j - 1] && dp[i][j - 1]);
                dp[i][j] |= (cs3[i + j - 2] == cs1[i - 1] && dp[i - 1][j]);
            }
        }
        return dp[cs1.length][cs2.length];
    }
}
