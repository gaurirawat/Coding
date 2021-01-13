package revision;
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
public class Graph_lc_longest_increasing_path_in_matrix {
    public int longestIncreasingPath(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }
        int max = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][]dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dp[i][j] == 0) {
                    max = Math.max(max, dfsExplore(i, j, m, n, dp, mat));
                }
            }
        }
        return max;
    }

    public int dfsExplore(int i, int j, int m, int n, int[][]dp, int[][]mat) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        for (int arr[]: new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}} ) {
            int newi = i + arr[0];
            int newj = j + arr[1];
            if (newi >= 0 && newj >= 0 && newi < m && newj < n && mat[newi][newj] > mat[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dfsExplore(newi, newj, m, n, dp, mat));
            }
        }
        dp[i][j]++;
        return dp[i][j];
    }
}
