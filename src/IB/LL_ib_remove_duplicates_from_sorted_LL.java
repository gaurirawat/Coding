package IB;
//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
public class LL_ib_remove_duplicates_from_sorted_LL {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            while(temp.next!=null && temp.val==temp.next.val)
                temp.next=temp.next.next;
            temp=temp.next;
        }
        return head;
    }
}
