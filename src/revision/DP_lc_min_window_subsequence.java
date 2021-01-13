package revision;
/*
//https://leetcode.com/problems/minimum-window-subsequence/
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such
minimum-length windows, return the one with the left-most starting index.

Example 1:
Input:
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation:
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.

Note:
All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
 */
public class DP_lc_min_window_subsequence {
    public String minWindow(String s, String t) {
        int[] alps = new int[26];
        int[] alpt = new int[26];
        for (char ch: s.toCharArray()) {
            alps[ch - 'a']++;
        }
        for (char ch: t.toCharArray()) {
            alpt[ch - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (alpt[i] > alps[i]) {
                return "";
            }
        }

        int[] dp = new int[s.length()];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < sChar.length; ++i) {
            dp[i] = (i == 0 || dp[i - 1] == 0)? 0 : dp[i - 1] + 1;
            if (sChar[i] == tChar[0]) {
                dp[i] = 1;
            }
        }
        // System.out.println(Arrays.toString(dp));

        for (int i = 1; i < tChar.length; ++i) {
            int temp[] = new int[s.length()];
            for (int j = 0; j < sChar.length; ++j) {
                if (j == 0) {
                    temp[j] = 0;
                }
                else if (tChar[i] == sChar[j] && dp[j - 1] != 0) {
                    temp[j] = dp[j - 1] + 1;
                }
                else if(temp[j - 1] != 0){
                    temp[j] = temp[j - 1] + 1;
                }
            }
            dp = temp;
            // System.out.println(Arrays.toString(dp));
        }

        String ans = "";
        for (int i = 0; i < sChar.length; ++i) {
            if (dp[i] != 0 && (ans.length() == 0 || ans.length() > dp[i])) {
                ans = s.substring(i - dp[i] + 1, i + 1);
            }
        }
        return ans;
    }
}
