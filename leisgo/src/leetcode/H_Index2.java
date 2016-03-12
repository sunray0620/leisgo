package leetcode;

/**
 * For Leetcode problem 275: H-Index2
 * Created by sunlei on 3/12/16.
 */
public class H_Index2 {
    public int hIndex(int[] citations) {
        // Corner case;

        // Assume is sorted in ascending order.
        int minIndex = -1;
        int maxIndex = citations.length;
        while (minIndex < maxIndex - 1) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (citations[midIndex] >= maxIndex - midIndex) {
                minIndex = midIndex;
            } else {
                maxIndex = midIndex;
            }
        }
        return minIndex;
    }
}
