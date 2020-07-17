package revision;
//https://leetcode.com/problems/minimum-path-sum/submissions/
public class DP_lc_min_cost_path {
    public int minPathSum(int[][] grid) {
        if(grid==null) return 0;
        int dp[]= new int[grid[0].length];

        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(j==0)
                    dp[j]=dp[j]+grid[i][j];
                else if(i==0)
                    dp[j]=dp[j-1]+grid[i][j];
                else
                    dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[grid[0].length-1];
    }
}
