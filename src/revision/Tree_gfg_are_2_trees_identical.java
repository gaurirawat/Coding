package revision;
//https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

public class Tree_gfg_are_2_trees_identical {
    boolean isIdentical(Node root1, Node root2)
    {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        return root1.data==root2.data && isIdentical(root1.left,root2.left) &&  isIdentical(root1.right,root2.right);
    }
}
