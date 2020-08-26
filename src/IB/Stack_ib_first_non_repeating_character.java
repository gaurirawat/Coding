package IB;

import java.util.*;

//https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
public class Stack_ib_first_non_repeating_character {
    public String solve(String a) {
        Deque<Character> st=new LinkedList<Character>();
        int alph[]=new int[26];
        char ch[]=a.toCharArray();
        StringBuffer s=new StringBuffer();
        for(char e:ch){
            if(alph[e-97]==0)
                st.addLast(e);
            else if(alph[e-97]==1)
                st.remove(new Character(e));
            alph[e-97]++;

            if(st.isEmpty())
                s.append('#');
            else
                s.append(st.peekFirst());
        }
        return s.toString();
    }
}
