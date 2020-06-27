package revision;
//https://www.interviewbit.com/problems/palindrome-list/
//https://leetcode.com/problems/palindrome-linked-list/submissions/
public class LL_ib_palindrome_list {
	public int lPalin(ListNode node) {
        if(node==null || node.next==null) return 1;
        ListNode head=node;
        ListNode slow=node;
        ListNode fast=node;
        while(fast!=null){
            if(fast.next==null){
                slow=slow.next;
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow has the remaining half of the list.
        ListNode prev=null, curr=slow, next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        if(prev!=null)curr=prev;
        
        while(curr!=null){
            if(curr.val!=head.val)
                return 0;
            curr=curr.next;
            head=head.next;
        }
        return 1;
    }
}
