package IB;
//https://www.interviewbit.com/problems/max-depth-of-binary-tree/
public class Tree_ib_max_depth_of_a_binary_tree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
