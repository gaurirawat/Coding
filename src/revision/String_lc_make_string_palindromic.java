package revision;
//https://leetcode.com/problems/shortest-palindrome/submissions/

public class String_lc_make_string_palindromic {
    public String shortestPalindrome(String s) {
        if(s==null|| s.length()==0) return s;
        char a[]=s.toCharArray();
        StringBuilder rev=new StringBuilder(s);
        rev=rev.reverse();
        char r[]=rev.toString().toCharArray();

        int lps[]=new int[a.length];
        int i=0;
        for(int j=1;j<a.length;++j){
            while(i!=0 && a[i]!=a[j])
                i=lps[i-1];
            if(a[i]==a[j])
                lps[j]=i++ +1;
            else
                lps[i]=0;
        }

        i=0;
        for(int j=0;j<a.length;++j){
            while(i!=0 && a[i]!=r[j])
                i=lps[i-1];
            if(a[i]==r[j])
                i++;
        }
        if(i==a.length) return s;
        else
            return rev.substring(0,a.length-i).toString()+s;
    }
}
