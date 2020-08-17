package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/longest-palindromic-subsequence/
public class DP_ib_longest_palindromic_subsequence{
    public int solve(String s) {
        char ch[]=s.toCharArray();
        int dp[][]=new int[ch.length+1][ch.length+1];
        for(int i=0;i<=ch.length;++i)
            Arrays.fill(dp[i],-1);
        return solveInner(dp, 0,ch.length-1,ch);
    }

    public int solveInner(int dp[][], int l, int r, char ch[]){
        if(l==r) return 1;
        if(l>=r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];

        if(ch[l]==ch[r])
            dp[l][r]=2+solveInner(dp, l+1,r-1,ch);
        else
            dp[l][r]=Math.max(solveInner(dp,l+1,r,ch),solveInner(dp,l,r-1,ch));
        return dp[l][r];
    }
}
