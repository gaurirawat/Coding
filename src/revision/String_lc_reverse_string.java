package revision;
//https://leetcode.com/problems/reverse-string/submissions/
public class String_lc_reverse_string {
	public void reverseString(char[] s) {
        int l=s.length;
        for(int i=0; i< l/2;++i ){
            char a= s[i];
            s[i]= s[l-i-1];
            s[l-i-1]= a;
        }
    }
}
