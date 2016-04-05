package leetcode.dp;

/**
 * For leetcode problem #96: Unique Binary Search Trees
 */
public class UniqueBST {

    // Complete DP, inspired by complete induction
    public int numTrees(int n) {
        int[] wtb = new int[n + 1];
        wtb[0] = wtb[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= i - 1; ++j) {
                int numOfLeftNodes = j;
                int numOfRightNodes = i - 1 - j;
                wtb[i] += wtb[numOfLeftNodes] * wtb[numOfRightNodes];
            }
        }
        return wtb[n];
    }
}
