package IB;
//https://www.interviewbit.com/problems/grid-unique-paths/
public class Math_ib_grid_unique_path {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return inner(0, 0, m, n, dp);
    }

    public int inner(int i, int j, int m, int n, int[][]dp) {
        if (i+1 == m || j+1 == n ) {
            return 1;
        }
        if (dp[i][j]==0) {
            dp[i][j] += inner(i+1, j, m, n, dp) + inner(i, j+1, m, n, dp);
        }
        return dp[i][j];
    }
}
