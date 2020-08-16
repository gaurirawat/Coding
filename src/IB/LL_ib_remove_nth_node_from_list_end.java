package IB;
//https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
public class LL_ib_remove_nth_node_from_list_end {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        if(head==null) return null;

        ListNode p=head;
        while(k--!=0 && p!=null)
            p=p.next;
        if(p==null){
            head=head.next;
            return head;
        }

        ListNode q=head;
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return head;
    }
}
