package IB;
//https://www.interviewbit.com/problems/merge-two-sorted-lists/
public class LL_ib_merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val < b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        } else {
            b.next = mergeTwoLists(a, b.next);
            return b;
        }
    }
}
