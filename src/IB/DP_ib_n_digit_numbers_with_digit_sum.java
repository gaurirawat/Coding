package IB;
//https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
public class DP_ib_n_digit_numbers_with_digit_sum {
    public int solve(int d, int sum) {
        if(d==0||sum==0) return 0;
        int mod=(int)Math.pow(10,9)+7;
        int dp[][]=new int[d+1][sum+1];
        long c=0;
        for(int i=1;i<=9;++i){
            if(i<=sum){
                c+=solveInner(d-1,sum-i, mod,dp);
                c=c%mod;
            }

        }
        return (int)c;
    }
    public int solveInner(int d, int sum, int mod, int dp[][]){
        if(sum==0) return 1;
        if(d==0) return 0;
        if(dp[d][sum]!=0) return dp[d][sum];
        long c=0;
        for(int i=0;i<=9;++i){
            if(i<=sum && (sum-i)<=(d-1)*9){
                c+=solveInner(d-1,sum-i, mod,dp);
                c=c%mod;
            }
        }
        dp[d][sum]=(int)c;
        return dp[d][sum];
    }
}
