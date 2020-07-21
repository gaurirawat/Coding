package revision;
//https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
public class LL_gfg_middle_node {
    int getMiddle(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next==null?fast.next:fast.next.next;
        }
        return slow.data;
    }
    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
}
/*
Leetcode soln SAME
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next==null?fast.next:fast.next.next;
        }
        return slow;
    }
 */