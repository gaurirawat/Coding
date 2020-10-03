package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/maximum-level-sum/
public class Tree_ib_maximum_level_sum {
    int max;
    public int solve(TreeNode root) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        max=0;
        calc(root, 0,l);
        return max;
    }
    public void calc(TreeNode root, int level, ArrayList<Integer> l){
        if(root==null) return;
        if(level==l.size())
            l.add(0);
        l.set(level,root.val+l.get(level));
        max=Math.max(max, l.get(level));
        calc(root.left,level+1,l);
        calc(root.right,level+1,l);
    }
}