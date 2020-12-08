package IB;
//https://www.interviewbit.com/problems/even-reverse/
public class LL_ib_even_reverse {
    public ListNode solve(ListNode head) {
        if(head==null|| head.next==null|| head.next.next==null|| head.next.next.next==null){
            return head;
        }
        ListNode oddH=head;
        ListNode evenH=head.next;
        ListNode oddT=oddH;
        ListNode evenT=evenH;
        head=head.next.next;
        while(head!=null){
            oddT.next=head;
            evenT.next=head.next;
            oddT=oddT.next;
            evenT=evenT.next;
            head=head.next!=null?head.next.next:head.next;
        }
        if(oddT!=null){
            oddT.next=null;
        }

        evenH=reverse(evenH);
        oddH=merge(oddH, evenH);
        return oddH;
    }

    public ListNode merge(ListNode a, ListNode b){
        ListNode head=a;
        while(a!=null){
            if(b!=null){
                ListNode temp=b;
                b=b.next;
                temp.next=a.next;
                a.next=temp;
                a=a.next;
            }
            a=a.next;
        }
        return head;
    }

    public ListNode reverse(ListNode node){
        if(node==null|| node.next==null){
            return node;
        }
        ListNode prev=null,curr=node,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
