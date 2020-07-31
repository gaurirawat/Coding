package IB;

import java.util.*;

//https://leetcode.com/problems/merge-k-sorted-lists/submissions/
//https://www.interviewbit.com/problems/merge-k-sorted-lists/

public class Heap_ib_merge_k_sorted_lists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a==null)
            return null;

        PriorityQueue<ListNode> q=new PriorityQueue<ListNode>(Comparator.comparingInt(v->v.val));
        for(ListNode x:a)
            if(x!=null)
                q.add(x);

        if(q.size()==0)
            return null;

        ListNode head= q.poll();
        ListNode temp=head;
        if(temp.next!=null)
            q.add(temp.next);
        while(q.size()!=0){
            temp.next=q.poll();
            temp=temp.next;
            if(temp.next!=null)
                q.add(temp.next);
        }
        return head;
    }
}
