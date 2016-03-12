package leetcode;

/**
 * For Leetcode problem 274: H-Index
 * Created by sunlei on 3/12/16.
 */
public class H_Index {
    public int hIndex(int[] citations) {
        // Corner case, length = 0
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int gMin = 0;
        int gMax = citations.length + 1;

        while(gMin < gMax - 1) {
            int gMid = (gMax + gMin) / 2;
            if (isHIndex(citations, gMid)) {
                gMin = gMid;
            } else {
                gMax = gMid;
            }
        }
        return gMin;
    }

    public boolean isHIndex(int[] citations, int candidate) {
        int egCount = 0;
        for (int citation : citations) {
            if (citation >= candidate) {
                egCount += 1;
            }
        }

        if (egCount >= candidate) {
            return true;
        } else {
            return false;
        }
    }
}
