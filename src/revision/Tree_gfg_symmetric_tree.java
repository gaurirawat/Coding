package revision;
//https://practice.geeksforgeeks.org/problems/symmetric-tree/1
public class Tree_gfg_symmetric_tree {
    public static boolean isSymmetric(Node root)
    {
        return isSymmetricInner(root,root);
    }

    public static boolean isSymmetricInner(Node root1, Node root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null) return false;
        return root1.data==root2.data&&isSymmetricInner(root1.left,root2.right)&&isSymmetricInner(root1.right,root2.left);
    }
}
