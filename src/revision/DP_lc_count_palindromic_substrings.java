package revision;
//https://leetcode.com/problems/palindromic-substrings/
public class DP_lc_count_palindromic_substrings {
    public int countSubstrings(String s) {
        int c= 0;

        for (int i = 0; i < s.length(); ++i) {
            c += countPalindromes(i, i, s);
            c += countPalindromes(i, i + 1, s);
        }
        return c;
    }

    public int countPalindromes(int l, int r, String s) {
        int c = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            c++;
        }
        return c;
    }
}
