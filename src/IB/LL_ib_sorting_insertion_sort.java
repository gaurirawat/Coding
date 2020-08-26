package IB;
//https://www.interviewbit.com/problems/insertion-sort-list/
public class LL_ib_sorting_insertion_sort {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode curr=head, next=curr.next;
        while(next!=null){
            if(head.val>=next.val){
                curr.next=curr.next.next;
                next.next=head;
                head=next;
            }
            else{
                ListNode nodei=head;
                while(nodei.next.val<next.val){
                    nodei=nodei.next;
                }
                if(nodei.next==next)
                    curr=curr.next;
                else{
                    curr.next=curr.next.next;
                    next.next=nodei.next;
                    nodei.next=next;
                }
            }
            next=curr.next;
        }
        return head;
    }
}
