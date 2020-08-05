package IB;
//https://www.interviewbit.com/problems/nearest-smaller-element/
import java.util.*;

public class Stack_ib_nearest_smaller_element {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
        Deque<Integer> st=new LinkedList<Integer>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int len=a.size();
        for(int i=0;i<len;++i){
            while(!st.isEmpty() && st.peekLast()>=a.get(i))
                st.pollLast();
            if(st.isEmpty())
                ans.add(-1);
            else
                ans.add(st.peekLast());
            st.addLast(a.get(i));
        }
        return ans;
    }
}
