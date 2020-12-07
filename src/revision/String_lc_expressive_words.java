package revision;
//https://leetcode.com/problems/expressive-words/
public class String_lc_expressive_words {

    public int expressiveWords(String s, String[] w) {
        int ans=0;
        int[] count=new int[s.length()];
        int t=0;
        for(int i=0;i<s.length();++i) {
            char ch=s.charAt(i);
            int c=1;
            while(i+1<s.length() && ch==s.charAt(i+1)) {
                c++;
                i++;
            }
            count[t++]=c;
        }
        for(int i=0;i<w.length;++i) {
            if(w[i].length()<=s.length() && isStretchy(s,count, w[i])){
                ans++;
                // System.out.println(w[i]);
            }
        }
        return ans;
    }

    public boolean isStretchy(String s, int[] arr, String a) {
        int si=0;
        int arri=0;
        boolean ans=false;
        for(int i=0;i<a.length();++i) {
            char ch= a.charAt(i);
            int c=1;
            while(i+1<a.length() && ch==a.charAt(i+1)) {
                c++;
                i++;
            }
            if(s.charAt(si)!=ch || arr[arri]<c){
                return false;
            } else{
                if(arr[arri]>c && arr[arri]<3) {
                    return false;
                }
                else{
                    ans=true;
                }
            }
            si+=arr[arri++];
        }
        if(s.length()!=si) {
            return false;
        }
        return ans;
    }
}
