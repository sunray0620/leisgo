package leetcode.dp;

/**
 * For leetcode problem #62: Unique Paths;
 */
public class UniquePaths {

    // This function uses bfs approaches,
    // so it does not look as concise as the most classic code.
    public int uniquePaths(int m, int n) {
        int[][] wtb = new int[m][n];
        wtb[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // go right;
                if (j + 1 < n) {
                    wtb[i][j + 1] += wtb[i][j];
                }

                // go down;
                if (i + 1 < m) {
                    wtb[i + 1][j] += wtb[i][j];
                }
            }
        }
        return wtb[m - 1][n - 1];
    }
}
