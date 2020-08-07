package IB;
//https://www.interviewbit.com/problems/implement-strstr/
//https://leetcode.com/problems/implement-strstr/
//Ref: https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class String_ib_KMP_implement_strstr {
    public int strStr(final String hh, final String nn) {
        if(hh==null||nn==null||hh.length()==0||nn.length()==0) return -1;
        char h[]=hh.toCharArray();
        char n[]=nn.toCharArray();
        int lps[]=new int[n.length];
        int i=0;
        for(int j=1;j<n.length;++j){
            while(n[j]!=n[i] && i!=0)
                i=lps[i-1];
            if(n[j]==n[i])
                lps[j]=i++ +1;
            else if(i==0)
                lps[j]=0;
        }

        for(int j=0;j<h.length;++j){
            if(i==n.length) return j-n.length;
            while(n[i]!=h[j] && i!=0)
                i=lps[i-1];
            if(n[i]==h[j]) ++i;
        }
        if(i==n.length) return h.length-n.length;
        return -1;
    }
}
