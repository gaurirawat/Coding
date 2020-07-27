package revision;
//https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
public class LL_ib_nth_node_from_end_of_list {
    int getNthFromLast(Node head, int n)
    {
        Node p=head,q=head;
        while(q!=null && n--!=0)
            q=q.next;
        if(q==null && n!=0)
            return -1;
        while(q!=null){
            q=q.next;
            p=p.next;
        }
        return p.data;
    }
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
}
