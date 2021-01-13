package revision;
//https://leetcode.com/problems/flip-equivalent-binary-trees/submissions/
public class Tree_lc_flip_equivalent {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        boolean result = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        result = result || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        return result;
    }
}
