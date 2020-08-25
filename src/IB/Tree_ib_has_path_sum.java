package IB;
//https://www.interviewbit.com/problems/path-sum/
public class Tree_ib_has_path_sum {
    boolean ans;
    public int hasPathSum(TreeNode root, int sum) {
        ans=false;
        hasPathSumInner(root, 0, sum);
        return ans?1:0;
    }


    public void hasPathSumInner(TreeNode root, int psum, int sum){
        if(root==null ||ans) return;
        if(root.left==null && root.right==null && psum+root.val==sum)
            ans=true;
        hasPathSumInner(root.left,psum+root.val,sum);
        hasPathSumInner(root.right,psum+root.val,sum);
    }
}
