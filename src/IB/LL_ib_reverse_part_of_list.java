package IB;
//https://www.interviewbit.com/problems/reverse-link-list-ii/
public class LL_ib_reverse_part_of_list {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null)return head;
        ListNode temp=head;
        int size=n-m+1;
        if(m==1)
            head=rev(temp,size);
        else{
            while(m>2){
                temp=temp.next;
                --m;
            }
            temp.next=rev(temp.next,size);
        }
        return head;
    }

    public ListNode rev(ListNode head, int size){
        ListNode curr=head,prev=null,next=null;
        while(size>=1){
            size--;
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head.next=curr;
        return prev;
    }
}
