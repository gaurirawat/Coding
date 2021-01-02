package revision;
//https://leetcode.com/problems/valid-palindrome/submissions/
public class String_lc_valid_palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<s.length(); ++i) {
            if( Character.isLetterOrDigit(s.charAt(i))) {
                sb.append( Character.toLowerCase( s.charAt(i)));
            }
        }
        int len=sb.length();
        for(int i=0;i<len/2;++i) {
            if(sb.charAt(i)!=sb.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}
