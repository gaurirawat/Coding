package IB;

import java.util.*;
// https://leetcode.com/problems/sliding-window-maximum/submissions/        diff input type
//https://www.interviewbit.com/problems/sliding-window-maximum/
public class Stack_ib_sliding_window_maximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Deque<Integer> dsi=new LinkedList<Integer>();//ds for storing index
        for(int i=0;i<b;++i){
            int e=a.get(i);
            while(!dsi.isEmpty()&&a.get(dsi.peekLast())<e)
                dsi.pollLast();
            dsi.addLast(i);
        }
        ans.add(a.get(dsi.peekFirst()));
        for(int i=b;i<a.size();++i){
            int e=a.get(i);
            while(!dsi.isEmpty()&&a.get(dsi.peekLast())<e)
                dsi.pollLast();
            dsi.addLast(i);
            if(dsi.peekFirst()<=i-b)
                dsi.pollFirst();
            ans.add(a.get(dsi.peekFirst()));
        }
        return ans;
    }
}
