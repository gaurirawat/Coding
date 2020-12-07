package revision;
//https://leetcode.com/problems/decode-string/submissions/
public class String_lc_decode_string {
    public String decodeString(String s) {
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(i<s.length()) {
            if(Character.isAlphabetic(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            else {
                int l=i;
                int r=i+1;
                while(Character.isDigit(s.charAt(r))) {
                    r++;
                }
                int rep=Integer.parseInt(s.substring(l,r));
                l=r+1;
                int c=1;
                while(c!=0) {
                    r++;
                    char ch= s.charAt(r);
                    if(ch=='[') c++;
                    else if(ch==']') c--;
                }
                String t=decodeString(s.substring(l,r));
                for(int j=0;j<rep;++j) {
                    sb.append(t);
                }
                i=r+1;
            }
        }
        return sb.toString();
    }
}
