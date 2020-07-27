package revision;
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
public class LL_flatten_a_LL_constant_space {
    public Node flatten(Node root)
    {
        if(root==null || root.next==null) return root;
        Node root2=flatten(root.next);
        root.next=null;
        Node head=merge(root, root2);
        return head;
    }

    public Node merge(Node a,Node b){
        if(b==null) return a;
        if(a==null) return b;
        if(a.data<=b.data){
            a.bottom=merge(a.bottom,b);
            return a;
        }
        else{
            b.bottom=merge(a,b.bottom);
            return b;
        }
    }
    class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
