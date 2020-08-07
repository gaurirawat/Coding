package IB;
//https://www.interviewbit.com/problems/palindrome-string/
public class String_ib_palindrome_string {
    public int isPalindrome(String a) {
        char[] crr=a.toCharArray();
        int l=0,r=crr.length-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(crr[l])) l++;
            while(l<r && !Character.isLetterOrDigit(crr[r])) r--;
            if(l<r && !(crr[l]+"").equalsIgnoreCase(crr[r]+""))
                return 0;
            l++;--r;
        }
        return 1;
    }
}
