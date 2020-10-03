package IB;
//https://www.interviewbit.com/problems/minimum-appends-for-palindrome/
public class String_ib_min_append_for_palindrome {
    public int solve(String s) {
        char srr[]=s.toCharArray();
        char rev[]=new StringBuffer(s).reverse().toString().toCharArray();
        int lps[]=new int[rev.length];
        int i=0;
        for(int j=1;j<rev.length;++j){
            while(rev[i]!=rev[j] && i!=0)
                i=lps[i-1];
            if(rev[i]==rev[j])
                lps[j]=++i;
        }
        i=0;
        for(int j=0;j<srr.length;++j){
            while(srr[j]!=rev[i] && i!=0)
                i=lps[i-1];
            if(rev[i]==srr[j])
                i++;
        }
        return s.length()-i;
    }
}