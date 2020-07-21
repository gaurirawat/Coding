package revision;
//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
public class LL_gfg_loop_detection {
    public static boolean detectLoop(Node head){
        if(head==null||head.next==null) return false;
        Node slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next==null?fast.next:fast.next.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
}
