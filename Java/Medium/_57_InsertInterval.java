package Java.Medium;

import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {
    public static void main(String[] args) {
        System.out.println("#57 - Insert Interval - Medium");

        int[][] input = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };
        int[] newInt = {4, 8};

        int[][] newSet = insert(input, newInt);
        for (int i = 0; i < newSet.length; i++) {
            System.out.println(newSet[i][0] + " " + newSet[i][1]);
        }

        return;
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
