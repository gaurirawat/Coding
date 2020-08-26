package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/distinct-subsequences/
public class DP_ib_distinct_subsequence {
    public int numDistinct(String a, String b) {
        int dp[][]=new int[a.length()][b.length()];
        for(int i=0;i<dp.length;++i)
            Arrays.fill(dp[i],-1);
        return numbDistinctInner(a,b,a.length()-1,b.length()-1,dp);
    }

    public int numbDistinctInner(String a, String b, int i, int j, int dp[][]){
        if(i<j) return 0;
        if(j==-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        int c=numbDistinctInner(a,b,i-1,j,dp);
        if(a.charAt(i)==b.charAt(j))
            c+=numbDistinctInner(a,b,i-1,j-1,dp);
        dp[i][j]=c;
        return dp[i][j];
    }
}
