package revision;
//https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1

public class Tree_gfg_count_leaves {
    int c;
    int countLeaves(Node node)
    {
        c=0;
        countLeavesInner(node);
        return c;
    }

    public void countLeavesInner(Node root){
        if(root==null) return;
        if(root.left==null && root.right==null) c++;
        countLeavesInner(root.left);
        countLeavesInner(root.right);
    }
}
