package revision;
//https://leetcode.com/problems/sort-list/solution/
public class LL_lc_sortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        head=sortList(head);
        head2=sortList(head2);
        head=mergeList(head, head2);
        return head;
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        if(head1==null) {
            return head2;
        }
        if(head2==null) {
            return head1;
        }
        if(head1.val<=head2.val) {
            head1.next=mergeList(head1.next, head2);
            return head1;
        }
        head2.next=mergeList(head1, head2.next);
        return head2;
    }
}
