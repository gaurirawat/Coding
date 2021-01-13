package revision;
//https://leetcode.com/problems/decode-ways/submissions/
public class String_lc_number_decode {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i != 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
