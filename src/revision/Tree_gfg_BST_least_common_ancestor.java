package revision;
//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
public class Tree_gfg_BST_least_common_ancestor {
    Node LCA(Node root, int n1, int n2)
    {
        if(root==null) return null;
        if(root.data==n1||root.data==n2)
            return root;
        if((root.data>n1 && root.data<n2)||(root.data<n1 && root.data>n2))
            return root;
        if(root.data>n1 && root.data>n2)
            return LCA(root.left,n1,n2);
        else
            return LCA(root.right,n1,n2);
    }
}
