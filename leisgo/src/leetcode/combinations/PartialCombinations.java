package leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * For leetcode problem 77: Combinations.
 */
public class PartialCombinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> ret = new ArrayList<>(k);
        getCombination(n, k, 1, ret, results);
        return results;
    }

    public void getCombination(int n, int k, int curAvailable, List<Integer> ret, List<List<Integer>> rets) {
        if (ret.size() == k) {
            rets.add(new ArrayList<>(ret));
            return;
        }

        if (n - curAvailable + 1 + ret.size() < k) {
            return;
        }

        for(int i = curAvailable; i <= n; ++i) {
            ret.add(i);
            getCombination(n, k, i + 1, ret, rets);
            ret.remove(ret.size() - 1);
        }
    }
}
