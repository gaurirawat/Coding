package revision;
// https://www.hackerearth.com/problem/algorithm/transform-the-expression-2/submissions/

/* Precedence is taken as follows 
1. ()
2. ^
3. * /
4. + -
An element with higher precedence can get inserted into the stack after an element of lower precedence.
Two elements of equal precedence cannot exist side by side.
*/


import java.util.*;
import java.io.*;
public class Stack_he_infix_to_postfix {
	public static void main(String[] args) throws Exception {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t= Integer.parseInt(br.readLine());
	while(t--!=0){
		String s= br.readLine();
		s= infixToPostfix(s);
		System.out.println(s);
		}
	}	

	public static String infixToPostfix(String s){
		s='('+s+')';
    	Deque<Character> st= new ArrayDeque<Character>();
    	int l= s.length();
    	String ans="";
    	for(int i=0; i<l ;++i){
			char ch= s.charAt(i);
			
			if(Character.isLetter(ch))
				ans+=ch;
    		
    		else if(ch=='(')
    			st.addLast(ch);
    		
    		else if(ch==')'){
    			ch=st.pollLast();
    			while(ch!='(') {
    				ans+=ch;
    				ch=st.pollLast();
    			}
    		}
    		
            else if(ch=='^'){
               ch=st.pollLast();
    			while(ch=='^'){
    				ans+=ch;
    				ch=st.pollLast();
    			} 
                st.addLast(ch);
    			st.addLast(s.charAt(i));
            }

    		else if(ch=='*' || ch=='/'){
               ch=st.pollLast();
    			while(ch=='*'|| ch=='/'){
    				ans+=ch;
    				ch=st.pollLast();
    			} 
                st.addLast(ch);
    			st.addLast(s.charAt(i));
            }
    			
    		else if(ch=='+'|| ch=='-'){
    			ch=st.pollLast();
    			while(ch=='^'|| ch=='*'|| ch=='/'||ch=='+'|| ch=='-'){
    				ans+=ch;
    				ch=st.pollLast();
    			}
    			st.addLast(ch);
    			st.addLast(s.charAt(i));
    		}
    	}
    	return ans;
    }
}