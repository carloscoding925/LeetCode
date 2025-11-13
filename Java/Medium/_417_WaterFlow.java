package Java.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_WaterFlow {
    public static void main(String[] args) {
        System.out.println("#417 - Pacific Atlantic Water Flow - Medium");

        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        List<List<Integer>> coords = pacificAtlantic(heights);

        System.out.println("Spots on Island where water flows to both: " + coords.toString());

        return;
    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, canReachPacific, i ,0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, canReachPacific, 0, j);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, canReachAtlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, canReachAtlantic, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        int m = heights.length;
        int n = heights[0].length;

        canReach[i][j] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI < 0 || newI >= m || newJ < 0 || newJ >= n) {
                continue;
            }

            if (canReach[newI][newJ] || heights[newI][newJ] < heights[i][j]) {
                continue;
            }

            dfs(heights, canReach, newI, newJ);
        }
    }
}
