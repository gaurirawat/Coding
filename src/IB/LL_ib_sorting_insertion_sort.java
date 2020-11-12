package IB;
//https://www.interviewbit.com/problems/insertion-sort-list/
public class LL_ib_sorting_insertion_sort {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;

        // add first element to sorted list
        ListNode sHead=head;
        head=head.next;
        sHead.next=null;

        //repeat until list is empty
        while(head!=null){

            //case where element has to be inserted at the start of the sorted list.
            if(sHead.val>=head.val){
                ListNode temp=head;
                head=head.next; //element removed from actual list
                temp.next=sHead;
                sHead=temp;
            }
            else{
                //insert element in the sorted list.
                ListNode curr=sHead,prev=sHead;
                while(curr!=null && curr.val<head.val){
                    prev=curr;
                    curr=curr.next;
                }
                ListNode temp=head;
                head=head.next; //element removed from actual list
                temp.next=prev.next;
                prev.next=temp;
            }
        }
        return sHead;
    }
}
