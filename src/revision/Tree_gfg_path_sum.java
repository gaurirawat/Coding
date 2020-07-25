package revision;
//https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
public class Tree_gfg_path_sum {
    int maxPath;
    int maxPathSum(Node root)
    {
        maxPath=Integer.MIN_VALUE;
        maxPathSumInner(root);
        return maxPath;
    }

    public int maxPathSumInner(Node root){
        if(root==null) return 0;
        int x=maxPathSumInner(root.left);
        int y=maxPathSumInner(root.right);
        if(root.left!=null && root.right!=null){
            maxPath=Math.max(maxPath,(x+y+root.data));
            // System.out.println(maxPath+" "+root.data);
        }
        if(root.left==null) return y+root.data;
        else if(root.right==null) return x+root.data;
        else return Math.max(x,y)+root.data;
    }
}
