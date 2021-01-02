package revision;
//https://leetcode.com/problems/scramble-string/submissions/
public class DP_lc_scramble_string {
    public boolean isScramble(final String A, final String B) {
        if(A.length() != B.length()) {
            return false;
        }
        return isScrambleInner(A, B);
    }

    public boolean isScrambleInner(String a, String b) {
        if(a.equals(b)) {
            return true;
        }
        int[] alpA = new int[26];
        int[] alpB = new int[26];
        for(int i=0; i<a.length(); ++i) {
            alpA[a.charAt(i)-'a']++;
            alpB[b.charAt(i)-'a']++;
        }
        for(int i=0;i<26; ++i){
            if(alpA[i]!=alpB[i]){
                return false;
            }
        }
        boolean ans= false;
        for(int i=1; i<a.length(); ++i) {
            ans= ans || (isScrambleInner(a.substring(0,i), b.substring(0,i)) &&
                    isScrambleInner(a.substring(i), b.substring(i)));
            ans = ans|| (isScrambleInner(a.substring(0,i), b.substring(b.length()-i)) &&
                    isScrambleInner(a.substring(i), b.substring(0, b.length()-i)));
        }
        return ans;
    }

}
