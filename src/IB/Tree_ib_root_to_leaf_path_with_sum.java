package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
public class Tree_ib_root_to_leaf_path_with_sum {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ans=new ArrayList<ArrayList<Integer>>();
        generatePath(root, sum, new ArrayList<Integer> ());
        return ans;
    }

    public void generatePath(TreeNode root,int remSum, ArrayList<Integer> l){
        if(root==null) return;
        if(root.left==null&&root.right==null && root.val==remSum){
            ArrayList<Integer> t=new ArrayList<Integer> ();
            t.addAll(l);
            t.add(root.val);
            ans.add(t);
            return;
        }
        l.add(root.val);
        generatePath(root.left, remSum-root.val, l);
        generatePath(root.right, remSum-root.val, l);
        l.remove(l.size()-1);
    }
}
