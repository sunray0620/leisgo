package leetcode.dp;

/**
 * For leetcode problem #72: Edit Distance.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        char[] wcs1 = word1.toCharArray();
        char[] wcs2 = word2.toCharArray();
        int[][] dp = new int[wcs1.length + 1][wcs2.length + 1];

        for (int i = 0; i <= wcs1.length; ++i) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= wcs2.length; ++j) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= wcs1.length; ++i) {
            for (int j = 1; j <= wcs2.length; ++j) {
                int minEditDist = Integer.MAX_VALUE;
                minEditDist = Math.min(minEditDist, dp[i][j - 1] + 1);  // Insert a character.
                minEditDist = Math.min(minEditDist, dp[i - 1][j] + 1);  // Delete a character.
                minEditDist = Math.min(minEditDist, (wcs1[i - 1] == wcs2[j - 1])? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1); // Replace a character.
                dp[i][j] = minEditDist;
            }
        }
        return dp[wcs1.length][wcs2.length];
    }
}
