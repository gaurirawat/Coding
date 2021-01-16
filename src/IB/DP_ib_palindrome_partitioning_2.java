package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/palindrome-partitioning-ii/
public class DP_ib_palindrome_partitioning_2 {
    public int minCut(String s) {
        char[]ch = s.toCharArray();
        int dp[] = new int[ch.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < ch.length; ++i) {
            dp[i] = Math.min(dp[i], i == 0 ? 0 : (dp[i - 1] + 1));
            checkForMinPalindrome(i - 1, i + 1, dp, ch);
            checkForMinPalindrome(i, i + 1, dp, ch);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[s.length() - 1];
    }

    public void checkForMinPalindrome(int l, int r, int[] dp, char[]ch) {
        while (l >=0 && r < ch.length && ch[l] == ch[r]) {
            int min = l == 0 ? 0 : (dp[l - 1] + 1);
            dp[r] = Math.min(dp[r], min);
            --l;
            ++r;
        }

        if (l == -1) {
            dp[r - 1] = 0;
        }
    }
}
