package revision;

import java.util.Arrays;
//https://leetcode.com/problems/coin-change/submissions/
public class DP_lc_coin_change {
    public int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int c: coins) {
            for (int i = c; i <= amount; ++i) {
                if (dp[i-c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
