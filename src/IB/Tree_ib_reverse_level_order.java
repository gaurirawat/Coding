package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/reverse-level-order
public class Tree_ib_reverse_level_order {
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<ArrayList<Integer>> l= new ArrayList<ArrayList<Integer>>();
        inner(root,l,0);
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=l.size()-1;i>=0;--i)
            ans.addAll(l.get(i));
        return ans;
    }

    public void inner(TreeNode root, ArrayList<ArrayList<Integer>> l, int level){
        if(root==null) return;
        if(level==l.size())
            l.add(new ArrayList<Integer>());
        l.get(level).add(root.val);
        inner(root.left, l, level+1);
        inner(root.right, l, level+1);
    }
}