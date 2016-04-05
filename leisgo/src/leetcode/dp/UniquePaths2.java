package leetcode.dp;

/**
 * For leetcode problem #63: Unique Paths 2
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] wtb = new int[m][n];
        wtb[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // go right;
                if (j + 1 < n && obstacleGrid[i][j + 1] == 0) {
                    wtb[i][j + 1] += wtb[i][j];
                }

                // go down;
                if (i + 1 < m && obstacleGrid[i + 1][j] == 0) {
                    wtb[i + 1][j] += wtb[i][j];
                }
            }
        }
        return wtb[m - 1][n - 1];
    }
}
