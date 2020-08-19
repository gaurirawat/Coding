package IB;

import java.util.Arrays;
//https://www.interviewbit.com/problems/flip-array/
public class DP_ib_min_sign_flips_for_sum_closest_to_zero {
    public int solve(final int[] a) {
        int sum = 0;
        for (int x : a)
            sum += x;
        sum /= 2;
        int dp[][] = new int[a.length + 1][sum + 1];
        for (int i = 0; i < a.length; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (a[i - 1] <= j && dp[i - 1][j - a[i - 1]] != Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - a[i - 1]] + 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = sum; i >= 0; --i) {
            if (dp[a.length][i] != Integer.MAX_VALUE)
                return dp[a.length][i];
        }
        return 0;
    }
}
