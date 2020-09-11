package revision;

public class Amazon {
    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int isSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        BinaryTreeNode root=findRoot(root1, root2);
        if(root==null) return -1;
        return compare(root, root2)?1:-1;
    }

    public boolean compare(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null|| root2==null) return false;
        if(root1.val!=root2.val) return false;
        return compare(root1.left, root2.left) && compare(root1.right, root2.right);
    }

    public BinaryTreeNode findRoot(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1==null) return null;
        if(root1.val==root2.val) return root1;
        BinaryTreeNode t=findRoot(root1.left,root2);
        if(t!=null) return t;
        t=findRoot(root1.right,root2);
        if(t!=null) return t;
        return null;
    }
}