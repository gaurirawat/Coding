package IB;
//https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
public class Tree_ib_DP_max_sum_path {
    int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        maxPathSumInner(root);
        return max;
    }

    public int maxPathSumInner(TreeNode root){
        if(root==null) return 0;
        int l=maxPathSumInner(root.left);
        int r=maxPathSumInner(root.right);
        int tmax=Math.max(0,Math.max(l+r,Math.max(l,r)))+root.val;
        max=Math.max(tmax,max);
        return Math.max(0, Math.max(l,r))+root.val;
    }
}
