package revision;
// https://leetcode.com/problems/unique-paths/submissions/

public class DP_lc_unique_path {

	public int uniquePaths(int m, int n) {
        return uniquePathsDP(0,0 ,new int[m][n]);
    }

    public int uniquePathsDP(int m, int n, int dp[][]){
        if(m==dp.length-1 || n==dp[0].length-1)//cond has ==length-1 here. not length.
            return 1;
        if(dp[m][n]==0)
            dp[m][n]= uniquePathsDP(m+1, n, dp)+uniquePathsDP(m, n+1, dp);
        return dp[m][n];
    }
}
