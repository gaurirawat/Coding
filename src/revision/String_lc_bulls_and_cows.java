package revision;
//https://leetcode.com/problems/bulls-and-cows/submissions/
public class String_lc_bulls_and_cows {
    public String getHint(String s, String g) {
        int[] sDig=new int[10];
        int[] gDig=new int[10];
        int same=0;
        int diff=0;
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i)==g.charAt(i)) {
                ++same;
            } else {
                sDig[s.charAt(i)-'0']++;
                gDig[g.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<10;++i) {
            diff+=Math.min(sDig[i],gDig[i]);
        }
        return same+"A"+diff+"B";
    }
}
