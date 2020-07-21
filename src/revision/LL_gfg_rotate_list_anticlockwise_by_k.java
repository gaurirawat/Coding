package revision;
//https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
public class LL_gfg_rotate_list_anticlockwise_by_k {
    public Node rotate(Node head, int k) {
        if(head==null|| head.next==null) return head;
        Node node=head;
        int len=0;
        while(node!=null){
            node=node.next;
            len++;
        }
        k=k%len;
        if(k==0)
            return head;
        node=head;
        while(--k!=0)
            node=node.next;
        Node newHead=node.next;
        node.next=null;

        node=newHead;
        while(node.next!=null)
            node=node.next;
        node.next=head;
        return newHead;
    }


    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

}

