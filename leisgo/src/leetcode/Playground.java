package leetcode;

import java.util.List;

/**
 * Created by sunlei on 3/12/16.
 */
public class Playground {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        List<List<Integer>> permutations = p.getPermutationsWithSwap(new int[] {1, 2, 3});
    }

    private static void printIntArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
