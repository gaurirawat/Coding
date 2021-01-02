package revision;
//https://leetcode.com/problems/validate-binary-search-tree/submissions/
public class Tree_lc_is_valid_BST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return validateTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public boolean validateTree(TreeNode root, int minVal, int maxVal) {
            if(root==null) {
                return true;
            }
            if( (root.val==minVal && root.left!=null) || (root.val==maxVal && root.right!=null )) {
                return false;
            }
            boolean currentValidity = (root.val>=minVal && root.val<=maxVal);
            return currentValidity && validateTree(root.left, minVal, root.val-1) && validateTree(root.right, root.val+1, maxVal);
        }
    }
}
