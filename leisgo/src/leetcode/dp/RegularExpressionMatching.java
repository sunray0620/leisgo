package leetcode.dp;

/**
 * For leetcode problem 10: Regular Expression Matching.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();
        boolean[][] dp = new boolean[pcs.length + 1][scs.length + 1];
        dp[0][0] = true;

        for (int i = 1; i <= pcs.length; ++i) {
            // If the next char is '*', we skip this line.
            if (i < pcs.length && pcs[i] == '*') {
                continue;
            }

            for (int j = 0; j <= scs.length; ++j) {
                if (pcs[i - 1] == '*' && pcs[i - 2] == '.') {
                    // Current pattern is .*
                    dp[i][j] = dp[i - 2][j] || (j > 0 && dp[i][j - 1]);

                } else if (pcs[i - 1] == '*') {
                    dp[i][j] = dp[i - 2][j] || (j > 0 && dp[i][j - 1] && scs[j - 1] == pcs[i - 2]);

                } else if (pcs[i - 1] == '.') {
                    dp[i][j] = j > 0 && dp[i - 1][j - 1];

                } else {
                    dp[i][j] = j > 0 && dp[i - 1][j - 1] && pcs[i - 1] == scs[j - 1];
                }
            }
        }
        return dp[pcs.length][scs.length];
    }
}
