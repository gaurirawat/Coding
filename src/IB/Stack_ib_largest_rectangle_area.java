package IB;

import java.util.*;

//https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
public class Stack_ib_largest_rectangle_area {
    public int largestRectangleArea(ArrayList<Integer> l) {
        int nsl[]=new int[l.size()];
        int nsr[]=new int[l.size()];
        Deque<Integer> st=new LinkedList<Integer>();
        for(int i=0;i<l.size();++i){
            while(!st.isEmpty() && l.get(st.peekLast())>=l.get(i))
                st.pollLast();
            if(st.isEmpty())
                nsl[i]=-1;
            else
                nsl[i]=st.peekLast();
            st.addLast(i);
        }
        st.clear();
        for(int i=l.size()-1;i>=0;--i){
            while(!st.isEmpty() && l.get(st.peekLast())>=l.get(i))
                st.pollLast();
            if(st.isEmpty())
                nsr[i]=l.size();
            else
                nsr[i]=st.peekLast();
            st.addLast(i);
        }
        int maxArea=0;
        for(int i=0;i<l.size();++i)
            maxArea=Math.max(maxArea,l.get(i)*(nsr[i]-nsl[i]-1));
        return maxArea;
    }

}
