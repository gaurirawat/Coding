package IB;
//https://www.interviewbit.com/problems/subset-sum-problem/
public class DP_ib_subset_sum_problem {
    public int solve(int[] a, int k) {
        boolean[][] dp= new boolean[a.length+1][k+1];
        for(int i=0;i<a.length;++i){
            dp[i][0]=true;
        }

        for(int i=1;i<=a.length;++i) {
            for(int j=1;j<=k;++j){
                dp[i][j]=dp[i-1][j];
                if(j>=a[i-1]){
                    dp[i][j]=dp[i][j]||dp[i-1][j-a[i-1]];
                }
            }
        }

        for(int i=1;i<=a.length;++i){
            if(dp[i][k]){
                return 1;
            }
        }
        return 0;
    }
}