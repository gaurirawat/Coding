package revision;
//https://leetcode.com/problems/longest-palindromic-substring/submissions/
public class DP_lc_longest_palindrome_substring {
    public String longestPalindrome(String s) {
        int ansl = 0;
        int ansr = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; ++i) {

            //odd length string
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < ch.length && ch[l] == ch[r]) {
                --l;
                ++r;
            }
            if (ansr - ansl < r-l-1) {
                ansl = l + 1;
                ansr = r;
            }


            //even length string
            l = i - 1;
            r = i;
            while (l >= 0 && r < ch.length && ch[l] == ch[r]) {
                --l;
                ++r;
            }
            if (ansr - ansl < r-l-1) {
                ansl = l + 1;
                ansr = r;
            }
        }
        return s.substring(ansl, ansr);
    }


    /*
    poor solution

    String answer;
    public String longestPalindrome(String s) {
        int dp[][] = new int[s.length()][s.length()];
        answer = "";
        longestPalindromeInner(0, s.length() - 1, s, dp);
        return answer;
    }

    public int longestPalindromeInner(int l, int r, String s, int[][]dp) {
        if (l > r) {
            return 1;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        dp[l][r] = -1;
        if (s.charAt(l) == s.charAt(r)) {
            if (longestPalindromeInner(l + 1, r - 1, s, dp) == 1) {
                dp[l][r] = 1;
                if (answer.length() < r - l + 1) {
                    answer = s.substring(l, r + 1);
                }
            }
        }

        longestPalindromeInner(l + 1, r, s, dp);
        longestPalindromeInner(l, r - 1, s, dp);

        return dp[l][r];
    }
     */
}
