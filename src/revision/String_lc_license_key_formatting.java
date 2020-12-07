package revision;
//https://leetcode.com/problems/license-key-formatting/
public class String_lc_license_key_formatting {
    public String licenseKeyFormatting(String s, int k) {
        if(s==null|| s.length()==0) {
            return s;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();++i) {
            char ch=s.charAt(i);
            if(ch!='-'){
                if(Character.isDigit(ch)){
                    sb.append(ch);
                } else {
                    sb.append(Character.toUpperCase(ch));
                }
            }
        }
        if(sb.length()==0) {
            return sb.toString();
        }
        int l=sb.length()%k;
        if(l==0){
            l=k;
        }
        s=sb.toString();
        StringBuilder ans= new StringBuilder(s.substring(0,l));
        for(int i=l;i<s.length();i+=k){
            ans.append("-"+s.substring(i,i+k));
        }
        return ans.toString();
    }
}
