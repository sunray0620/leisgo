package leetcode.dp;

/**
 * For leetcode problem 53: Maximum Subarray
 */
public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int lMax = nums[0];
        int gMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            lMax = Math.max(lMax + nums[i], nums[i]);
            gMax = Math.max(gMax, lMax);
        }
        return gMax;
    }
}
