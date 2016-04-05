package leetcode.dp;

/**
 * For leetcode problem
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int lmax = nums[0];
        int lmin = nums[0];
        int gmax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int lmax1 = Math.max(nums[i], Math.max(lmax * nums[i], lmin * nums[i]));
            int lmin1 = Math.min(nums[i], Math.min(lmax * nums[i], lmin * nums[i]));
            lmax = lmax1;
            lmin = lmin1;
            gmax = Math.max(gmax, lmax);
        }
        return gmax;
    }
}
