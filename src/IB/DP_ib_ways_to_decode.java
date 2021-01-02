package IB;
//https://www.interviewbit.com/problems/ways-to-decode/
public class DP_ib_ways_to_decode {
    public int numDecodings(String s) {
        if(s.length()==0) {
            return 0;
        }

        int dp[]= new int[s.length()];
        int mod= (int)Math.pow(10,9) +7;
        return numInner(0, s, dp, mod);
    }

    public int numInner(int i, String s, int[]dp, int mod) {
        if (i == s.length()) {
            return 1;
        }
        if (i > s.length() || s.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }

        dp[i] = numInner(i + 1, s, dp, mod);
        if ((s.charAt(i) == '1' || s.charAt(i) == '2') && i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num <= 26) {
                dp[i] += numInner(i + 2, s, dp, mod);
            }
        }
        dp[i] %= mod;
        return dp[i];
    }
}
