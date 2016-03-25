package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunlei on 3/24/16.
 */
public class Permutation {

    /**
     * Given a collection of distinct numbers, return all possible permutations.
     * @param nums: an array of distinct numbers.
     * @return: All permutations of input numbers.
     */
    public List<List<Integer>> permuteWithSwap(int[] nums) {
        return null;
    }

    public void getPermutationWithExtraSpace(int[] nums, int startPos, int[] result, List<List<Integer>> results) {
        if (startPos == nums.length) {
            results.add(new ArrayList(Arrays.asList(result)));
            return;
        }

        for (int i = startPos; i < nums.length; ++i) {
            result[startPos] = nums[i];
            getPermutationWithExtraSpace(nums, startPos + 1, result, results);
        }
    }

}
