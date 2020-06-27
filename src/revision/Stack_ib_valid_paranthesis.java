package revision;
//https://www.interviewbit.com/problems/generate-all-parentheses/
import java.util.*;
public class Stack_ib_valid_paranthesis {
	public int isValid(String a) {
        Deque<Character> st = new ArrayDeque<Character>();
        int len=a.length();
        for(int i=0; i< len; ++i){
            char c = a.charAt(i);
            if(c=='{'||c=='('|| c=='[')
                st.addLast(c);
            else if(c=='}'||c==')'|| c==']'){
                if(st.peekLast()==null)
                    return 0;
                    System.out.println("remove");
                char l =st.pollLast().charValue();
                if((c=='{'&& l=='}')||(c=='('&& l==')')|| (c=='[' && l==']'))
                    continue;
                else 
                    return 0;
            }
        }
        if(st.size()==0)
            return 1;
        return 0;
    }
}
