package leetcode;

import leetcode.combinations.Combinations;

/**
 * Created by sunlei on 3/12/16.
 */
public class Playground {
    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4, 2);
    }

    private static void printIntArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
