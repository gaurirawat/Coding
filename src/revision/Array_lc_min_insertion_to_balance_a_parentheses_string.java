package revision;
//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
public class Array_lc_min_insertion_to_balance_a_parentheses_string {

    public int minInsertions(String s) {
        StringBuilder sb=new StringBuilder();
        int c=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==')'){
                if(i+1!=s.length() && s.charAt(i+1)==')'){
                    i++;
                }
                else
                    c++;
            }
            sb.append(s.charAt(i));
        }
        int t=0;
        for(int i=0;i<sb.length();++i){
            if(sb.charAt(i)=='(')
                t++;
            if(sb.charAt(i)==')'){
                if(t==0)
                    c+=1;
                else
                    --t;
            }
        }
        c+=(t*2);
        return c;
    }
}
