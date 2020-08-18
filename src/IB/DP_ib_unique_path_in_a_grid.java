package IB;
//https://www.interviewbit.com/problems/unique-paths-in-a-grid/
public class DP_ib_unique_path_in_a_grid {
    public int uniquePathsWithObstacles(int[][] a) {
        if(a[0][0]==1 || a[a.length-1][a[0].length-1]==1) return 0;
        int dp[][]=new int[a.length][a[0].length];
        return uniquePathDP(0,0,dp,a);
    }

    public int uniquePathDP(int i, int j, int dp[][], int a[][]){
        if(i==a.length-1 && j==a[0].length-1) return 1;
        if(i==a.length || j==a[0].length || a[i][j]==1) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j]=uniquePathDP(i+1,j,dp,a)+uniquePathDP(i,j+1,dp,a);
        return dp[i][j];
    }
}
