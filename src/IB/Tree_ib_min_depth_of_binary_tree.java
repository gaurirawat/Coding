package IB;
//https://www.interviewbit.com/problems/min-depth-of-binary-tree/
public class Tree_ib_min_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int ans1=minDepth(root.left);
        int ans2=minDepth(root.right);
        if(ans1!=0&&ans2!=0)
            return Math.min(ans1,ans2)+1;
        else if(ans1==0)
            return ans2+1;
        return ans1+1;
    }
}
