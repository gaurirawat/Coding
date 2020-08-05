package IB;
//https://www.interviewbit.com/problems/next-pointer-binary-tree/
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
public class Tree_ib_next_right_pointer_1 {
    public void connect(TreeLinkNode root) {
        if(root==null||root.left==null) return ;
        TreeLinkNode head=root;
        TreeLinkNode prev=root.left;
        while(root!=null){
            prev.next=root.right;
            prev=prev.next;
            root=root.next;
            if(root!=null){
                prev.next=root.left;
                prev=prev.next;;
            }
        }
        connect(head.left);
    }
}
