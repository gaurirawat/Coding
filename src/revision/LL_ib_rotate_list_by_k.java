package revision;
//https://www.interviewbit.com/problems/rotate-list/
//https://leetcode.com/problems/rotate-list/submissions/
public class LL_ib_rotate_list_by_k {
	public ListNode rotateRight(ListNode head, int b) {
		if(head==null) return null;
        ListNode p=head;
        int len=0;
        while(p!=null){
            len++; 
            p=p.next;
        }
        b=b%len;
        if(b==0)
            return head;
            
        p=head;
        while(b!=0 && p!=null){
            p=p.next;
            b--;
            len++;
        }
 
        ListNode q= head;
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        p.next=head;
        head=q.next;
        q.next=null;
        return head;
    }
}
