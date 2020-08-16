package IB;
//https://www.interviewbit.com/problems/reorder-list/
public class LL_ib_reorder_list {
    public ListNode reorderList(ListNode node) {
        if(node==null||node.next==null||node.next.next==null) return node;

        ListNode slow=node, fast=node.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next==null? fast.next: fast.next.next;
        }

        ListNode node1=node;
        ListNode node2=slow.next;
        slow.next=null;
        node2=reverse(node2);

        while(node2!=null){
            ListNode temp=node1.next;
            node1.next=node2;
            node2=node2.next;
            node1.next.next=temp;
            node1=temp;
        }
        return node;
    }

    public ListNode reverse(ListNode node){
        if(node==null||node.next==null) return node;
        ListNode curr=node, prev=null, next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
