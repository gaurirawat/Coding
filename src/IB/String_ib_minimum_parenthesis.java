package IB;
//https://www.interviewbit.com/problems/minimum-parantheses/
public class String_ib_minimum_parenthesis {
    public int solve(String s) {
        char[] ch=s.toCharArray();
        int open=0;
        int add=0;
        for(int i=0;i<ch.length;++i){
            if(ch[i]=='('){
                open++;
            }
            else if(ch[i]==')'){
                if(open>0){
                    open--;
                } else {
                    add++;
                }
            }
        }
        return add+open;
    }
}
