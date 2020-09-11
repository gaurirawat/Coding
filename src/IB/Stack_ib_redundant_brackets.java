package IB;

import java.util.*;

//https://www.interviewbit.com/problems/redundant-braces/
public class Stack_ib_redundant_brackets {
    public int braces(String l) {
        Deque<Character> st=new LinkedList<Character>();
        for(int i=0;i<l.length();++i){
            char ch=l.charAt(i);
            if(ch=='('||ch=='+'||ch=='-'||ch=='*'||ch=='/')
                st.addLast(ch);
            if(ch==')'){
                if(st.peekLast()=='(')
                    return 1;
                else{
                    st.pollLast();
                    st.pollLast();
                }
            }
        }
        return 0;
    }
}
