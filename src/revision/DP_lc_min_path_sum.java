package revision;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-path-sum/submissions/
public class DP_lc_min_path_sum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr: dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return minPathInner(0, 0, grid, dp);
    }

    public int minPathInner(int i, int j, int[][]grid, int[][]dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (dp[i][j] == Integer.MAX_VALUE) {
            if (i + 1 < grid.length) {
                dp[i][j] = minPathInner(i + 1, j, grid, dp);
            }
            if (j + 1 < grid[0].length) {
                dp[i][j] = Math.min(dp[i][j], minPathInner(i, j + 1, grid, dp));
            }
            dp[i][j] += grid[i][j];
        }
        return dp[i][j];
    }
}
