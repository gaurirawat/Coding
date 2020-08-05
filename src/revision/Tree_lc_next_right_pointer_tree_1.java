package revision;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
//https://www.interviewbit.com/problems/next-pointer-binary-tree/
public class Tree_lc_next_right_pointer_tree_1 {
    public Node connect(Node root) {
        if(root==null||root.left==null) return root;
        Node prev=root.left;
        Node head=root;
        while(root!=null){
            prev.next=root.right;
            prev=prev.next;
            root=root.next;
            if(root!=null){
                prev.next=root.left;
                prev=prev.next;
            }
        }
        connect(head.left);
        return head;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
