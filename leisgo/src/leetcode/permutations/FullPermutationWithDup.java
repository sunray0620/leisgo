package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class FullPermutationWithDup {
    public List<List<Integer>> getPermuteWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> ret = new ArrayList<>(nums.length);
        boolean[] isUsed = new boolean[nums.length];
        this.rGetPermuteWithDup(nums, 0, isUsed, ret, results);
        return results;
    }

    public void rGetPermuteWithDup(int[] nums, int curPos, boolean[] isUsed, List<Integer> ret, List<List<Integer>> results) {
        if (curPos == nums.length) {
            results.add(new ArrayList<>(ret));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
            // If used by previous stage, then skip.
            if (isUsed[i]) {
                continue;
            }

            // If used by current stage, skip too.
            // Line 29 - 38 are the core part for dup case.
            boolean WasUsedForCurPos = false;
            for(int j = 0; j < i; ++j) {
                if(nums[j] == nums[i]) {
                    WasUsedForCurPos = true;
                    break;
                }
            }
            if (WasUsedForCurPos) {
                continue;
            }

            isUsed[i] = true;
            ret.add(nums[i]);
            this.rGetPermuteWithDup(nums, curPos + 1, isUsed, ret, results);
            isUsed[i] = false;
            ret.remove(ret.size() - 1);
        }
    }
}
