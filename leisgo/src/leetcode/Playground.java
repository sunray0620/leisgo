package leetcode;

import leetcode.recursions.LetterOfPhoneNumber;

/**
 * Created by sunlei on 3/12/16.
 */
public class Playground {
    public static void main(String[] args) {
        LetterOfPhoneNumber l = new LetterOfPhoneNumber();
        l.letterCombinations("2");
    }

    private static void printIntArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
