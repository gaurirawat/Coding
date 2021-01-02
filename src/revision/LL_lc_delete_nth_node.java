package revision;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
public class LL_lc_delete_nth_node {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- != 0) {
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
