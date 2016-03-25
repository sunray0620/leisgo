package leetcode;

/**
 * Created by sunlei on 3/12/16.
 */
public class Playground {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] testInts = new int[] { 1, 1, 5 };
        for (int i = 0; i < 20; ++i) {
            printIntArray(testInts);

            //
            np.nextPermutation(testInts);
        }
    }

    private static void printIntArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
