package revision;
//https://leetcode.com/problems/reverse-linked-list/submissions/
//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
public class LL_gfg_reverse_LL {
    Node reverseList(Node head)
    {
        Node curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
}
/*
Leetcode son SAME
  public ListNode reverseList(ListNode head) {
        ListNode curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
 */
