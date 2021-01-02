package IB;
//https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
public class Tree_ib_DP_max_sum_path {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathInner(root);
        return max;
    }

    public int maxPathInner(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathInner(root.left);
        int right = maxPathInner(root.right);
        int currPath = root.val + Math.max(0, ( left>0 ? left : 0) + (right>0 ? right : 0) );
        max = Math.max(max, currPath);

        return Math.max(root.val, root.val + Math.max(left, right));
    }
}
