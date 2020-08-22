package IB;
//https://www.interviewbit.com/problems/identical-binary-trees/
public class Tree_ib_identical_binary_trees {
    public int isSameTree(TreeNode a, TreeNode b) {
        return isSameInner(a,b)?1:0;
    }

    public boolean isSameInner(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        return a.val==b.val && isSameInner(a.left, b.left) && isSameInner(a.right, b.right);
    }
}
