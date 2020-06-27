package revision;
//https://www.interviewbit.com/problems/redundant-braces/
import java.util.*;
public class Stack_ib_redundant_brackets {
	public int braces(String a) {
        char[] s= a.toCharArray();
        Deque<Character> st= new LinkedList<Character>();
        for(char ch:s){
            if(ch!=')')
                st.addLast(ch);
            else{
                boolean flag=true;
                while(ch!='('){
                    ch= st.removeLast().charValue();
                    if(ch=='+'|| ch=='-'|| ch=='*'||ch=='/')
                        flag=false;
                }
                if(flag)
                    return 1;
            }
        }
        return 0;
    }
}
