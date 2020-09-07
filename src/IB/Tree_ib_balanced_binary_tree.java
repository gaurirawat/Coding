package IB;
//https://www.interviewbit.com/problems/balanced-binary-tree/
public class Tree_ib_balanced_binary_tree {
    int ans;
    public int isBalanced(TreeNode root) {
        ans=1;
        isBalancedInner(root);
        return ans;
    }

    public int isBalancedInner(TreeNode root){
        if(root==null) return 0;
        int l=isBalancedInner(root.left);
        if(ans==0) return -1;
        int r=isBalancedInner(root.right);
        if(ans==0) return -1;
        if(l-r>1||r-l>1)
            ans=0;
        return Math.max(l,r)+1;
    }
}
