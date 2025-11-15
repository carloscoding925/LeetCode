package Java.Medium;

import java.util.Arrays;

public class _435_NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println("#435 - Non-Overlapping Intervals - Medium");

        int[][] input = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };
        int numToErase = eraseOverlapIntervals(input);

        System.out.println("Number of Intervals to Remove: " + numToErase);

        return;
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                removals++;
            }
            else {
                lastEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
