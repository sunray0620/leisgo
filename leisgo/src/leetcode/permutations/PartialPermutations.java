package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class PartialPermutations {
    public List<List<Integer>> partialPermute(int[] nums, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> ret = new ArrayList<>(nums.length);
        boolean[] isUsed = new boolean[nums.length];
        this.dfs(nums, k, 0, isUsed, ret, results);
        return results;
    }

    public void dfs(int[] nums, int k, int curPos, boolean[] isUsed, List<Integer> ret, List<List<Integer>> results) {
        if (ret.size() == k) {
            results.add(new ArrayList<>(ret));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if(isUsed[i]) {
                continue;
            }
            ret.add(nums[i]);
            this.dfs(nums, k, curPos + 1, isUsed, ret, results);
            ret.remove(ret.size() - 1);
        }
    }
}