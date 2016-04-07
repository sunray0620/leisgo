package leetcode.dp;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * For leetcode problem #95: Unique Binary Search Trees II
 */
public class UniqueBSTrees2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        // Corner case:
        if (n <= 0) {
            return new ArrayList<>();
        }

        // Regular:
        // initialize dp table.
        List<List<List<TreeNode>>> wtb = new ArrayList<>();
        for (int i = 0; i <= n + 1; ++i) {
            List<List<TreeNode>> newRow = new ArrayList<>();
            for (int j = 0; j <= n + 1; ++j) {
                newRow.add(new ArrayList<TreeNode>());
            }
            wtb.add(newRow);
        }

        // set up initial values.
        for (int i = 1; i <= n + 1; ++i) {
            wtb.get(i).get(i - 1).add(null);
        }

        // dp.
        for (int diff = 0; diff < n; ++diff) {
            for (int i = 1; i <= n && i + diff <= n; ++i) {
                int j = i + diff;
                List<TreeNode> curSubTrees = new ArrayList<>();
                for (int cur = i; cur <= j; ++cur) {

                    for (int p = 0; p < wtb.get(i).get(cur - 1).size(); ++p) {
                        TreeNode ln = wtb.get(i).get(cur - 1).get(p);
                        for (int q = 0; q < wtb.get(cur + 1).get(j).size(); ++q) {
                            TreeNode rn = wtb.get(cur + 1).get(j).get(q);
                            TreeNode newNode = new TreeNode(cur);
                            newNode.left = ln;
                            newNode.right = rn;
                            curSubTrees.add(newNode);
                        }
                    }
                }
                wtb.get(i).set(j, curSubTrees);
            }
        }
        return wtb.get(1).get(n);
    }
}
