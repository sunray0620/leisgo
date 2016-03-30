package leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For leetcode problem 90: Subsets II
 * Get subsets of an array with dups
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        List<Integer> tempRet = new ArrayList<>();
        Arrays.sort(num);
        this.rSubsetsWithDup(num, 0, tempRet, ret);
        return ret;
    }

    public void rSubsetsWithDup(int[] num, int startPos, List<Integer> tempRet, List<List<Integer>> ret) {
        int numLength = num.length;
        if (startPos == numLength) {
            return;
        }

        for (int i = startPos; i < numLength; ++i) {
            if (i > startPos && num[i] == num[i - 1]) {
                continue;
            }
            // Add ith element into set;
            tempRet.add(num[i]);
            ret.add(new ArrayList<>(tempRet));
            this.rSubsetsWithDup(num, i + 1, tempRet, ret);
            tempRet.remove(tempRet.size() - 1);
        }
    }
}
