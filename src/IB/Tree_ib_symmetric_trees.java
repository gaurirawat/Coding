package IB;
//https://www.interviewbit.com/problems/symmetric-binary-tree/
//https://leetcode.com/problems/symmetric-tree/
public class Tree_ib_symmetric_trees {

    public int isSymmetric(TreeNode root) {
        return isSymmetricInner(root,root)?1:0;
    }

    public boolean isSymmetricInner(TreeNode a,TreeNode b){
        if(a==b&&a==null)
            return true;
        if(a==null||b==null)
            return false;
        return a.val==b.val && isSymmetricInner(a.left,b.right) && isSymmetricInner(a.right,b.left);
    }

}
