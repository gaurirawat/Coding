package revision;
//https://leetcode.com/problems/odd-even-linked-list/submissions/
public class LL_odd_even_list {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;

        head = head.next.next;
        while(head != null) {
            odd.next = head;
            odd = odd.next;

            even.next = head.next;
            even = even.next;

            head = head.next != null ? head.next.next : head.next;
        }

        odd.next = evenHead;
        return oddHead;
    }
}
