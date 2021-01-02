package revision;
//https://leetcode.com/problems/maximal-square/
public class DP_lc_maximal_square {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int [rows][cols];

        int max=0;
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                dp[i][j] = matrix[i][j]-'0';
                if(i!=0 && j!=0 && dp[i][j]==1) {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
                max= Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}
