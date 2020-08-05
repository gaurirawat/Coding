package IB;
//https://www.interviewbit.com/problems/remove-half-nodes/
public class Tree_ib_remove_half_nodes {
    public TreeNode solve(TreeNode root) {
        if(root==null) return null;
        root.left=solve(root.left);
        root.right=solve(root.right);
        if(root.left==null && root.right!=null)
            return root.right;
        else if(root.right==null &&root.left!=null)
            return root.left;
        else
            return root;
    }
}
