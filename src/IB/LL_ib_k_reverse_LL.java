package IB;

//https://www.interviewbit.com/problems/k-reverse-linked-list/
//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

public class LL_ib_k_reverse_LL {
    public ListNode reverseList(ListNode head, int k) {
        if(head==null||head.next==null||k<=1) return head;
        int c=0;
        ListNode node=head;
        ListNode curr=head,prev=null,next=null;
        while(c<k && curr!=null){
            c++;
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head.next=reverseList(curr,k);
        return prev;
    }
}
