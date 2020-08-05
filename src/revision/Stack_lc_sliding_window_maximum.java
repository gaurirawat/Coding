package revision;

import java.util.*;
//https://leetcode.com/problems/sliding-window-maximum/submissions/
//https://www.interviewbit.com/problems/sliding-window-maximum/         diff input type
public class Stack_lc_sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int b) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Deque<Integer> dsi=new LinkedList<Integer>();//ds for storing index
        for(int i=0;i<b;++i){
            int e=nums[i];
            while(!dsi.isEmpty()&&nums[dsi.peekLast()]<e)
                dsi.pollLast();
            dsi.addLast(i);
        }
        ans.add(nums[dsi.peekFirst()]);
        for(int i=b;i<nums.length;++i){
            int e=nums[i];
            while(!dsi.isEmpty()&&nums[dsi.peekLast()]<e)
                dsi.pollLast();
            dsi.addLast(i);
            if(dsi.peekFirst()<=i-b)
                dsi.pollFirst();
            ans.add(nums[dsi.peekFirst()]);
        }
        int arr[]=new int[ans.size()];
        for(int i=0;i<arr.length;++i)
            arr[i]=ans.get(i);
        return arr;
    }
}
