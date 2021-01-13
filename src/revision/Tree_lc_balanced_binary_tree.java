package revision;
//https://leetcode.com/problems/balanced-binary-tree/
public class Tree_lc_balanced_binary_tree {
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        isBalancedInner(root);
        return balanced;
    }

    public int isBalancedInner(TreeNode root) {
        if (root == null || !balanced) {
            return 0;
        }
        int left = isBalancedInner(root.left);
        int right = isBalancedInner(root.right);
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
