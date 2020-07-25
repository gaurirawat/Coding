package revision;
//https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
public class Tree_gfg_height {
    int height(Node root)
    {
        if(root==null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}
