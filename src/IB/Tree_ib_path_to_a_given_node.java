package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/path-to-given-node/
public class Tree_ib_path_to_a_given_node {
    ArrayList<Integer> l;
    public ArrayList<Integer> solve(TreeNode root, int k) {
        l=new ArrayList<Integer>();
        solveInner(root,k);
        return l;
    }
    public void solveInner(TreeNode root, int k) {
        if(root==null) return;
        if(root.val==k) {
            l.add(root.val);
            return;
        }
        solveInner(root.left,k);
        if(l.size()==0) solveInner(root.right,k);
        if(l.size()!=0) l.add(0,root.val);
    }
}
