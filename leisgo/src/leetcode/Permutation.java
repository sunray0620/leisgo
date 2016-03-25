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
    public List<List<Integer>> getPermutationsWithSwap(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        // Corner cases:
        if (nums == null || nums.length == 0) {
            return results;
        }

        //
        List<Integer> tempRet = new ArrayList<Integer>(nums.length);
        boolean[] isUsed = new boolean[nums.length];
        getPermutationWithSwap(nums, 0, results);
        return results;
    }

    public void getPermutationWithExtraSpace(int[] numbers, int startPos, boolean[] isUsed, List<Integer> result, List<List<Integer>> results) {
        if (startPos == numbers.length) {
            results.add(new ArrayList(result));
            return;
        }

        for (int i = 0; i < numbers.length; ++i) {
            if (isUsed[i]) {
                continue;
            }
            result.add(numbers[i]);
            isUsed[i] = true;
            getPermutationWithExtraSpace(numbers, startPos + 1, isUsed, result, results);
            isUsed[i] = false;
            result.remove(result.size() - 1);
        }
    }

    public void getPermutationWithSwap(int[] numbers, int startPos, List<List<Integer>> results) {
        if (startPos == numbers.length) {
            List<Integer> tempResult = new ArrayList<>(numbers.length);
            for (int v : numbers) {
                tempResult.add(v);
            }
            results.add(tempResult);
            return;
        }

        for (int i = startPos; i < numbers.length; ++i) {
            swapElement(numbers, startPos, i);
            getPermutationWithSwap(numbers, startPos + 1, results);
            swapElement(numbers, startPos, i);
        }
    }

    private void swapElement(int[] nums, int m, int n) {
        int swapTemp = nums[m];
        nums[m] = nums[n];
        nums[n] = swapTemp;
    }
}
