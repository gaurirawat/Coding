package revision;

import java.util.*;

//https://leetcode.com/problems/perfect-squares/
public class DP_lc_perfect_squares {
    public int numSquares(int n) {
        if (n <= 1) {
            return n;
        }
        ArrayList<Integer> sq = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            sq.add(i * i);
        }

        return findLeastNumber(sq, n);
    }

    public int findLeastNumber(ArrayList<Integer> sq, int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < sq.size(); ++i) {
            for (int j = sq.get(i); j <= n; ++j) {
                dp[j] = Math.min(dp[j], 1 + dp[j - sq.get(i)]);
            }
        }
        return dp[n];
    }
}
