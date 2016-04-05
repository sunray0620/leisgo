package leetcode;


import leetcode.dp.MaxProductSubarray;
import leetcode.recursions.LetterOfPhoneNumber;

/**
 * Created by sunlei on 3/12/16.
 */
public class Playground {
    public static void main(String[] args) {
        MaxProductSubarray mps = new MaxProductSubarray();
        int ret = mps.maxProduct(new int[] {-4, -3, -2});
        System.out.println(ret);
    }

    private static void printIntArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
