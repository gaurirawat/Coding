package IB;
//https://www.interviewbit.com/problems/palindrome-list/
public class LL_ib_palindrome_list {
    public int lPalin(ListNode a) {
        if(a==null||a.next==null) return 1;
        ListNode slow=a,fast=a;
        while(fast!=null&& fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast=fast.next==null?fast.next:fast.next.next;
        }
        slow=slow.next;
        ListNode b=reverse(slow);
        while(b!=null){
            if(a.val!=b.val) return 0;
            a=a.next;
            b=b.next;
        }
        return 1;
    }

    public ListNode reverse(ListNode a){
        ListNode curr=a,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
