package revision;
//https://leetcode.com/problems/longest-palindromic-substring/submissions/
public class DP_lc_longest_palindrome {
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
}
