package IB;

import java.util.*;

//https://www.interviewbit.com/problems/min-stack/
public class Stack_ib_min_stack {
    Deque<Integer> st=new LinkedList<Integer>();
    Deque<Integer> minSt=new LinkedList<Integer>();
    int min=Integer.MAX_VALUE;
    public void push(int x) {
        st.addLast(x);
        if(minSt.isEmpty() || x<minSt.peekLast())
            minSt.addLast(x);
    }

    public void pop() {
        if(!st.isEmpty()){
            int x=st.pollLast();
            if(x==minSt.peekLast())
                minSt.pollLast();
        }
    }

    public int top() {
        if(st.isEmpty())
            return -1;
        else
            return st.peekLast();
    }

    public int getMin() {
        if(minSt.isEmpty())
            return -1;
        return minSt.peekLast();
    }
}
