package IB;
//https://www.interviewbit.com/problems/min-sum-path-in-matrix/
public class DP_ib_min_sum_path_in_matrix {
    public int minPathSum(int[][] a) {
        int dp[][]=new int[a.length][a[0].length];
        return minPathSumDP(0,0,a,dp);
    }

    public int minPathSumDP(int i, int j, int[][]a, int dp[][]){
        if(i==a.length-1 && j==a[0].length-1)
            return a[i][j];
        else if(i==a.length ||j==a[0].length)
            return Integer.MAX_VALUE;
        if(dp[i][j]==0){
            dp[i][j]=Math.min(minPathSumDP(i+1,j,a,dp),minPathSumDP(i,j+1,a,dp))+a[i][j];
        }
        return dp[i][j];
    }
}
