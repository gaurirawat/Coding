package IB;
//https://www.interviewbit.com/problems/invert-the-binary-tree/
public class Tree_ib_invert_a_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
