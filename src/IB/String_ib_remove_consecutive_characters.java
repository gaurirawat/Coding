package IB;
//https://www.interviewbit.com/problems/remove-consecutive-characters/
public class String_ib_remove_consecutive_characters {
    public String solve(String s, int k) {
        StringBuilder sb= new StringBuilder();
        char ch[]=s.toCharArray();
        for(int i=0;i<s.length();++i) {
            int l=i;
            while(i+1<ch.length && ch[i+1]==ch[l]){
                i++;
            }
            if((i-l+1)!=k){
                sb.append(s.substring(l,i+1));
            }
        }
        return sb.toString();
    }
}
