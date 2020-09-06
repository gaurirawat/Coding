package IB;
//https://www.interviewbit.com/problems/longest-palindromic-substring/
public class String_ib_longest_palindromic_substring {
    String ans;
    int anslen;
    int left;
    public String longestPalindrome(String a) {
        if(a.length()<=1) return a;
        left=0;
        ans=a.charAt(0)+"";
        for(int i=0;i<a.length()-1;++i){
            longestPalindromicInner(i-1,i+1,a);
            longestPalindromicInner(i,i+1,a);
        }
        return ans;
    }

    public void longestPalindromicInner(int l, int r, String a){
        if(l==-1||r==a.length()) return;
        if(a.charAt(l)==a.charAt(r)){
            int len=r-l+1;
            if(len>anslen||(len==anslen && l<left)){
                ans=a.substring(l,r+1);
                anslen=len;
                left=l;
            }
            longestPalindromicInner(l-1,r+1,a);
        }
    }
}
