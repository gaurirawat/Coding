package revision;
import java.util.*;

// https://leetcode.com/problems/basic-calculator-ii/

public class Stack_lc_basic_Calculator {

	 public int calculate(String s){
        s='('+s+')';
        Deque<Character> st= new ArrayDeque<Character>();
        Deque<Integer> ans= new ArrayDeque<Integer>();

        int l= s.length();
        Integer num=0;
        for(int i=0; i<l ;++i){
            char ch= s.charAt(i);
            
             if (ch == ' ') {
                continue;
            }

            if(Character.isDigit(ch))
                num= num*10+ Integer.parseInt(ch+"");
            
            else 
            {
                ans.addLast(num);
                num=0;
                if(ch=='(')
                    st.addLast(ch);
                
                else if(ch==')'){
                    ch=st.pollLast();
                    while(ch!='(') {
                        ans.addLast(calculate(ans.pollLast(), ans.pollLast(), ch));
                        ch=st.pollLast();
                    }
                }

                else if(ch=='*' || ch=='/'){
                   ch=st.pollLast();
                    while(ch=='*'|| ch=='/'){
                        ans.addLast(calculate(ans.pollLast(), ans.pollLast(), ch));
                        ch=st.pollLast();
                    } 
                    st.addLast(ch);
                    st.addLast(s.charAt(i));
                }
                    
                else if(ch=='+'|| ch=='-'){
                    ch=st.pollLast();
                    while(ch=='*'|| ch=='/'||ch=='+'|| ch=='-'){
                        ans.addLast(calculate(ans.pollLast(), ans.pollLast(), ch));
                        ch=st.pollLast();
                    }
                    st.addLast(ch);
                    st.addLast(s.charAt(i));
                }
            }
        }
        return ans.pollLast();
    }

    public int calculate(int a, int b, Character c){
        switch(c){
            case '+': return b+a;
            case '-': return b-a;
            case '*': return b*a;
            case '/': return b/a;
        }
        return 0;
    }

}
