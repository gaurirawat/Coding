package revision;
//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
public class LL_lc_pairwise_swap {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode nextSet=head.next.next;
        ListNode first=head;
        ListNode second=head.next;
        second.next=first;
        head=second;
        first.next=swapPairs(nextSet);
        return head;
    }
}
