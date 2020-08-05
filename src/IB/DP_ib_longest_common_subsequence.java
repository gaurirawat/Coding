package IB;
//https://www.interviewbit.com/problems/longest-common-subsequence/
public class DP_ib_longest_common_subsequence {
    public int solve(String a, String b) {
        if(a.length()==0||b.length()==0)return 0;
        int dp[][]=new int[a.length()+1][b.length()+1];
        for(int i=1;i<=a.length();++i){
            for(int j=1;j<=b.length();++j){
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[a.length()][b.length()];
    }
}
