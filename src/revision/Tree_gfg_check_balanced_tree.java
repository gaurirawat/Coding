package revision;
//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class Tree_gfg_check_balanced_tree {
    boolean var;
    boolean isBalanced(Node root)
    {
        var=true;
        isBalancedInner(root);
        return var;
    }

    public int isBalancedInner(Node root){
        if(root==null) return 0;
        int l=isBalancedInner(root.left);
        int r=isBalancedInner(root.right);
        if(Math.abs(l-r)>1)
            var=false;
        return Math.max(l,r)+1;
    }
}
