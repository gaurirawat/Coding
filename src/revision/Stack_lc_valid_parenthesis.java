package revision;

import java.util.*;

//https://leetcode.com/problems/valid-parentheses/submissions/
public class Stack_lc_valid_parenthesis {
    public boolean isValid(String s) {
        Deque<Character> st=new LinkedList<Character>();
        for(int i=0;i<s.length();++i) {
            char character=s.charAt(i);
            if(character=='{' || character=='(' || character=='[') {
                st.addLast(character);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char last= st.pollLast();
                if((character==']' && last!='[') ||
                        (character=='}' && last!='{') ||
                        (character==')' && last!='(')){
                    return false;
                }
            }
        }
        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
