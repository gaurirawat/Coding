package IB;
//https://www.interviewbit.com/problems/repeating-subsequence/
public class DP_ib_repeating_sub_sequence {
    public int anytwo(String a) {
        int dp[][]=new int[a.length()+1][a.length()+1];
        for(int i=1;i<=a.length();++i){
            for(int j=1;j<=a.length();++j){
                if(i!=j && a.charAt(i-1)==a.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[a.length()][a.length()]>1?1:0;
    }
}
