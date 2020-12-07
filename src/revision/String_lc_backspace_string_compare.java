package revision;

import java.util.*;

//https://leetcode.com/problems/backspace-string-compare/submissions/
public class String_lc_backspace_string_compare {
    public boolean backspaceCompare(String S, String T) {
    if(parse(S).equals(parse(T))) {
        return true;
    }
    return false;
}
    public String parse(String s) {
        Deque<Character> st=new LinkedList<Character>();
        for(char ch:s.toCharArray()) {
            if(ch!='#') {
                st.addLast(ch);
            }
            else if(!st.isEmpty()){
                st.pollLast();
            }
        }
        StringBuilder sb=new StringBuilder("");
        for(char ch:st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
