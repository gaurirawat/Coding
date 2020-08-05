package IB;

import java.util.*;
//https://www.interviewbit.com/problems/evaluate-expression/
//https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/

public class Stack_ib_evaluate_postfix_expression {
    public int evalRPN(String[] a) {
        Deque<Integer> st=new LinkedList<Integer>();
        for(String s:a){
            char ch=s.charAt(0);
            // System.out.println(s);
            if((ch=='+'||ch=='-'||ch=='*'||ch=='/')&&s.length()==1){
                int y=st.pollLast();
                int x=st.pollLast();
                if(ch=='+') st.addLast(x+y);
                else if(ch=='-') st.addLast(x-y);
                else if(ch=='*') st.addLast(x*y);
                else if(ch=='/') st.addLast(x/y);
            }
            else
                st.addLast(Integer.parseInt(s));
        }
        return st.pollLast();
    }
}
