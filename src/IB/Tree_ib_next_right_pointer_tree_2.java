package IB;
//https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
public class Tree_ib_next_right_pointer_tree_2 {
    public void connect(TreeLinkNode root) {
        if (root==null) {
            return;
        }
        while(root!=null) {
            TreeLinkNode prev = new TreeLinkNode(0);
            TreeLinkNode newHead = prev;
            while(root!=null) {
                if (root.left!=null) {
                    prev.next=root.left;
                    prev = root.left;
                }
                if (root.right!=null) {
                    prev.next=root.right;
                    prev = root.right;
                }
                root=root.next;
            }
            root=newHead.next;
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}