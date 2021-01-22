package revision;
//https://leetcode.com/problems/split-two-strings-to-make-palindrome/submissions/
public class String_lc_split_string_to_make_palindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        return isPalindrome(a, 0, a.length() - 1) ||
                isPalindrome(b, 0, b.length() - 1) ||
                isSequencePossible(a, b, 0, a.length() - 1) ||
                isSequencePossible(b, a, 0, a.length() - 1);
    }

    public boolean isSequencePossible(String a, String b, int l, int r) {
        if ( l>= r) {
            return true;
        }
        if (a.charAt(l) == b.charAt(r)) {
            return isSequencePossible(a, b, l + 1, r - 1);
        }
        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }

    public boolean isPalindrome(String a, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (a.charAt(l) == a.charAt(r)) {
            return isPalindrome(a, l + 1, r - 1);
        }
        return false;
    }
}
