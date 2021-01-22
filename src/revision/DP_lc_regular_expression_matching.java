package revision;
//https://leetcode.com/problems/regular-expression-matching/submissions/
public class DP_lc_regular_expression_matching {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0 && s.length() == 0)  {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        int dp[][]= new int[s.length() + 1][p.length() + 1];
        return isMatchDP(s.toCharArray(), p.toCharArray(), s.length(), p.length(), dp) == 1;
    }

    public int isMatchDP(char[] s, char[] p, int i, int j, int dp[][]){
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == 0 && p[j - 1] == '*') {
            dp[i][j] = isMatchDP(s, p, i, j - 2, dp);
            return dp[i][j];
        }
        if (i == 0 || j == 0) {
            return -1;
        }

        dp[i][j] = -1;
        if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
            dp[i][j] = isMatchDP(s, p, i - 1, j -1 , dp);
        }
        if (p[j - 1] == '*') {
            dp[i][j] = isMatchDP(s, p, i, j - 2, dp);
            if (dp[i][j] != 1 && (p[j - 2] == s[i - 1] || p[j - 2] == '.')) {
                dp[i][j] = isMatchDP(s, p, i - 1, j, dp);
            }
        }
        return dp[i][j];
    }
}
