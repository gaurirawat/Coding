package IB;
//https://www.interviewbit.com/problems/merge-two-binary-tree/
public class Tree_ib_merge_two_binary_trees {
    public TreeNode solve(TreeNode a, TreeNode b) {
        if(a==null) return b;
        if(b==null) return a;
        a.val=a.val+b.val;
        a.left=solve(a.left,b.left);
        a.right=solve(a.right, b.right);
        return a;
    }
}