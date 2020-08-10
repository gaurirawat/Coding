package IB;
//https://www.interviewbit.com/problems/reverse-link-list-recursion/
public class LL_ib_reverse_LL_recursiely {
    ListNode head;
    public ListNode reverseList(ListNode node) {
        head=null;
        ListNode end=reverseRec(node);
        end.next=null;
        return head;
    }
    public ListNode reverseRec(ListNode node){
        if(node.next==null){
            head=node;
            return node;
        }
        ListNode next=reverseRec(node.next);
        next.next=node;
        return node;
    }
}
