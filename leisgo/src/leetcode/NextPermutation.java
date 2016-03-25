package leetcode;

/**
 * For leetcode problem 31: Next Permutation
 * Created by leis on 3/21/16.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i >= 0 && nums[i] >= nums[i + 1]; --i) {
        }

        if (i >= 0) {
            for (j = nums.length - 1; nums[j] <= nums[i]; --j) {
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for(; start < end; ++start, --end) {
            swap(nums, start, end);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int swapTemp = nums[x];
        nums[x] = nums[y];
        nums[y] = swapTemp;
    }
}
