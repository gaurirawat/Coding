package IB;
import java.util.ArrayList;
//https://www.interviewbit.com/problems/unique-binary-search-trees/
public class Tree_ib_generate_unique_BST {
    public ArrayList<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generateInner(1,n);
    }

    public ArrayList<TreeNode> generateInner(int st, int end){
        ArrayList<TreeNode> res=new ArrayList<TreeNode>();
        if(st>end)
            res.add(null);
        for(int i=st;i<=end;++i){
            ArrayList<TreeNode> lst=generateInner(st,i-1);
            ArrayList<TreeNode> rst=generateInner(i+1,end);
            for(TreeNode x: lst){
                for(TreeNode y: rst){
                    TreeNode root=new TreeNode(i);
                    root.left=x;
                    root.right=y;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
