package revision;
// https://leetcode.com/problems/unique-paths-ii/submissions/

public class DP_lc_unique_path_2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstaclesDP(0,0, new int[obstacleGrid.length][obstacleGrid[0].length], obstacleGrid);
    }

    public int uniquePathsWithObstaclesDP(int m, int n,int [][]dp, int [][]ob){
    	if(m==dp.length-1 && n==dp[0].length-1 && ob[m][n]!=1)
    		return 1;
    	if(m>=dp.length||n>=dp[0].length||ob[m][n]==1)
    		return 0;
    	if(dp[m][n]==0)
    		dp[m][n]= uniquePathsWithObstaclesDP(m+1,n,dp,ob)+uniquePathsWithObstaclesDP(m,n+1,dp,ob);
    	return dp[m][n];
    }
	
}
