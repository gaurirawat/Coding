package IB;
//https://www.interviewbit.com/problems/sort-list/
public class LL_ib_sorting_merge_sort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : fast.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.val < head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        }
        else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}
