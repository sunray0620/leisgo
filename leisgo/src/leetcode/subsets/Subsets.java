package leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For leetcode problem 78: Subsets
 * Get subset of an array without any dup.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<Integer>());
        List<Integer> ret = new ArrayList<>();
        this.rSubsets(nums, 0, ret, results);
        return results;
    }

    public void rSubsets(int[] nums, int curPos, List<Integer> ret, List<List<Integer>> results) {
        if (curPos == nums.length) {
            return;
        }

        for (int i = curPos; i < nums.length; ++i) {
            ret.add(nums[i]);
            results.add(new ArrayList<>(ret));
            this.rSubsets(nums, i + 1, ret, results);
            ret.remove(ret.size() - 1);
        }
    }
}
