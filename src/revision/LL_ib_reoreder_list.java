package revision;
//https://www.interviewbit.com/problems/reorder-list/
//https://leetcode.com/problems/reorder-list/submissions/
public class LL_ib_reoreder_list {
	public ListNode reorderList(ListNode a) {
        if(a==null|| a.next==null|| a.next.next==null) 
            return a;
        //find mid point
        ListNode head=a;
        ListNode slow=a, fast=a;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast= fast.next==null?null:fast.next.next;
        }
        
        //reverse half list
        ListNode curr=slow.next, prev=null, next=null;
        slow.next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        curr=prev;
        
        //merge a and curr (reversed list)
        while(curr!=null){
            ListNode temp=curr;
            curr=curr.next;
            temp.next=a.next;
            a.next=temp;
            a=a.next.next;
        }
        return head;
    }
}
