package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/arrange-ii/
/*
Not initializing the array by -1 gave us TLE because the ans could actually be 0 a lot of times but that was getting
 recalculated multiple times. Hence prefer initialising using 0;
 */
public class DP_ib_arrange_horses {
    public int arrange(String s, int n) {
        int[][] dp = new int[s.length()+1][n+1];
        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        return arrangeInner(s.length(), n, s.toCharArray(), dp);
    }

    public int arrangeInner(int l, int n, char[] ch, int[][]dp) {
        if(l == n) {
            return 0;
        }
        if (l<n || n==0) {
            return -1;
        }
        if (dp[l][n]!=-1) {
            return dp[l][n];
        }

        int black = 0;
        int white = 0;

        int min = Integer.MAX_VALUE;
        for (int i=l; i>=n; --i) {
            if (ch[i-1] == 'B') {
                black++;
            }
            else{
                white++;
            }
            int rem = arrangeInner(i-1, n-1, ch, dp);
            if (rem!= -1 ) {
                min = Math.min(min, rem + black * white);
            }
            if (min == 0) {
                break;
            }
        }
        dp[l][n] = min;
        return dp[l][n];
    }
}
