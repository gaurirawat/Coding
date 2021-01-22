package revision;
//https://leetcode.com/problems/unique-binary-search-trees/submissions/
public class DP_lc_unique_binary_search_trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        return numTreesDP(n, dp);
    }

    public int numTreesDP(int n, int[]dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += numTreesDP(i, dp) * numTreesDP(n - i - 1, dp);
        }
        dp[n] = count;
        return count;
    }
}
