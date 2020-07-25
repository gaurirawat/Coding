package revision;
//https://www.interviewbit.com/problems/valid-binary-search-tree/
public class Tree_ib_is_BST_valid {
    public int isValidBST(TreeNode root) {
        return isValidBSTInner(root, Integer.MIN_VALUE, Integer.MAX_VALUE)?1:0;
    }

    public boolean isValidBSTInner(TreeNode root, int lb, int ub){
        if(root==null) return true;
        if(root.val<=lb || root.val>=ub)
            return false;
        return isValidBSTInner(root.left,lb,root.val)&&isValidBSTInner(root.right,root.val,ub);
    }
}
