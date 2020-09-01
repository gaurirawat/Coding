package IB;

import java.util.*;

//https://www.interviewbit.com/problems/longest-valid-parentheses/
public class DP_ib_longest_valid_parenthesis {
    public int longestValidParentheses(String a) {
        char ch[]=a.toCharArray();
        Deque<Integer> st=new LinkedList<Integer>();
        int max=0;
        st.add(-1);
        for(int i=0;i<ch.length;++i){
            if(ch[i]==')'){
                st.pollLast();
                if(!st.isEmpty())
                    max=Math.max(max, i-st.peekLast());
                else
                    st.add(i);
            }
            else
                st.add(i);
        }
        return max;
    }
}