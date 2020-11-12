package IB;
//https://www.interviewbit.com/problems/balanced-parantheses/
public class Stack_ib_balanced_parenthesis {
    public int solve(String s) {
        int c=0;
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;++i){
            if(ch[i]=='(')++c;
            if(ch[i]==')')--c;
            if(c<0) return 0;
        }
        if(c!=0)return 0;
        return 1;
    }
}