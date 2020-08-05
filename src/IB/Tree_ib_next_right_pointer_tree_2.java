package IB;
//https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
public class Tree_ib_next_right_pointer_tree_2 {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode nextHead = new TreeLinkNode(0), nextTail = nextHead;
        TreeLinkNode node = root;
        while (node != null){
            if (node.left != null) {
                nextTail.next = node.left;
                nextTail = node.left;
            }
            if (node.right != null) {
                nextTail.next = node.right;
                nextTail = node.right;
            }
            node = node.next;
        }
        connect(nextHead.next);
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
/*
    if(root==null) return null;
    Node curr=root;
    Node nLevPrev=null;

    while(curr!=null){
        if(nLevPrev==null)
            nLevPrev=curr.left;
        else if(curr.left!=null){
            nLevPrev.next=curr.left;
            nLevPrev=nLevPrev.next;
        }

        if(nLevPrev==null)
            nLevPrev=curr.right;
        else if(curr.right!=null){
            nLevPrev.next=curr.right;
            nLevPrev=nLevPrev.next;
        }
        curr=curr.next;
    }
    connect(root.left);
    connect(root.right);
    return root;
 */