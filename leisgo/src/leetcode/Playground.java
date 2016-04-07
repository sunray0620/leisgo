package leetcode;


import leetcode.dp.MaxProductSubarray;
import leetcode.dp.RegularExpressionMatching;
import leetcode.dp.UniqueBSTrees2;
import leetcode.recursions.LetterOfPhoneNumber;

/**
 * Created by sunlei on 3/12/16.
 */
public class Playground {
    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        rem.isMatch("aaa", "ab*a");
    }

    private static void printIntArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
