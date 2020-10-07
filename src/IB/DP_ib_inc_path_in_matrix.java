package IB;
//https://www.interviewbit.com/problems/increasing-path-in-matrix/
public class DP_ib_inc_path_in_matrix {
    public int solve(int[][] a) {
        int dp[][]=new int[a.length][a[0].length];
        dp[0][0]=1;
        for(int i=0;i<a.length;++i){
            for(int j=0;j<a[0].length;++j){
                if(i!=0 && a[i][j]>a[i-1][j] && dp[i-1][j]!=0)
                    dp[i][j]=dp[i-1][j]+1;
                if(j!=0 && a[i][j]>a[i][j-1] && dp[i][j-1]!=0)
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-1]+1);
            }
        }
        return dp[a.length-1][a[0].length-1]==0?-1:dp[a.length-1][a[0].length-1];
    }
}
