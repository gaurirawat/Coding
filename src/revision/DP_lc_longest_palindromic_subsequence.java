package revision;
//https://leetcode.com/problems/longest-palindromic-subsequence/submissions/

import java.util.Arrays;

public class DP_lc_longest_palindromic_subsequence {
    public int longestPalindromeSubseq(String s) {
        int dp[][]= new int[s.length()][s.length()];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return longestPalindromicSubseqDP(s,0, s.length()-1, dp);
    }

    public int longestPalindromicSubseqDP(String s,int i,int j,int dp[][]){
        if(i>j)
            return 0;
        if(i==j)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];

        if(s.charAt(i)==s.charAt(j))
            return dp[i][j]= 2+longestPalindromicSubseqDP(s,i+1,j-1,dp);
        else
            return dp[i][j]=Math.max(longestPalindromicSubseqDP(s,i+1,j,dp),
                    longestPalindromicSubseqDP(s,i,j-1,dp));

    }
}
