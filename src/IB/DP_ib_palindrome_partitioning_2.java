package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/palindrome-partitioning-ii/
public class DP_ib_palindrome_partitioning_2 {
    public int minCut(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        char[] ch = s.toCharArray();
        for (int i=1; i<s.length(); ++i) {
            dp[i] = Math.min(dp[i-1]+1, dp[i]);

            int l=i;
            int r=i+1;
            while (l>=0 && r<s.length() && ch[l] == ch[r]) {
                --l; ++r;
            }
            dp[r-1] = Math.min(dp[r-1], l==-1? 0 : dp[l]+1 );

            l=i-1;
            r=i+1;
            while (l>=0 && r<s.length() && ch[l] == ch[r]) {
                --l; ++r;
            }
            dp[r-1] = Math.min(dp[r-1], l==-1? 0 : dp[l]+1 );
        }

        return dp[s.length()-1];
    }
}
