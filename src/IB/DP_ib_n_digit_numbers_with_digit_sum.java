package IB;
//https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
public class DP_ib_n_digit_numbers_with_digit_sum {
    public int solve(int n, int sum) {
        if (sum == 0 && n == 1) {
            return 1;
        }
        if (9 * n > sum) {
            return 0;
        }

        int[][] dp = new int[n + 1][sum + 1];
        long c = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 1; i <= 9; ++i) {
            c += innerSolve(n - 1, sum - i, mod, dp);
            c %= mod;
        }
        return (int) c;
    }

    public int innerSolve(int n, int sum, int mod, int[][]dp) {
        if (n == 0 && sum == 0) {
            return 1;
        }
        if (n * 9 < sum || sum < 0) {
            return 0;
        }
        if (dp[n][sum] != 0) {
            return dp[n][sum];
        }

        long c = 0;
        for (int i = 0; i <= 9; ++i) {
            c += innerSolve(n - 1, sum - i, mod, dp);
            c %= mod;
        }
        dp[n][sum] = (int) c;
        return dp[n][sum];
    }
}
