package IB;
//https://www.interviewbit.com/problems/grid-unique-paths/
public class Math_ib_grid_unique_path {
    public int uniquePaths(int r, int c) {
        int dp[][]=new int[r][c];
        return uniquePathInner(0,0,dp);
    }

    public int uniquePathInner(int i, int j, int dp[][]){
        if(i==dp.length-1 && j==dp[0].length-1)
            return 1;
        if(i==dp.length||j==dp[0].length)
            return 0;
        if(dp[i][j]==0){
            dp[i][j]= uniquePathInner(i+1,j,dp);
            dp[i][j]+=uniquePathInner(i,j+1,dp);
        }
        return dp[i][j];

    }
}
