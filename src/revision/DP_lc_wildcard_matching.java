package revision;
//https://leetcode.com/problems/wildcard-matching/
public class DP_lc_wildcard_matching {
    public boolean isMatch(String s, String p) {
        int[][]dp = new int[s.length() + 1][p.length() + 1];
        return isMatchInner(s.length(), p.length(), s.toCharArray(), p.toCharArray(), dp) == 1;
    }

    public int isMatchInner(int i, int j, char[] s, char[] p, int[][]dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == 0 && p[j - 1] == '*') {
            dp[i][j] = isMatchInner(i, j - 1, s, p, dp);
            return dp[i][j];
        }
        if (i == 0 || j == 0) {
            return -1;
        }

        dp[i][j] = -1;
        if (s[i - 1] == p[j - 1] || p[j - 1] == '?' || p[j - 1] == '*') {
            dp[i][j] = isMatchInner(i - 1, j - 1, s, p, dp);
        }
        if (p[j - 1] == '*' && dp[i][j] != 1) {
            dp[i][j] = isMatchInner(i - 1, j, s, p, dp);
            if (dp[i][j] != 1) {
                dp[i][j] = isMatchInner(i, j - 1, s, p, dp);
            }
        }
        return dp[i][j];
    }
}
