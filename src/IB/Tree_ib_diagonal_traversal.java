package IB;

import java.util.*;
//https://www.interviewbit.com/problems/diagonal-traversal/
public class Tree_ib_diagonal_traversal {
    HashMap<Integer, ArrayList<Integer>> map;
    int max;
    public ArrayList<Integer> solve(TreeNode root) {
        map=new HashMap<Integer, ArrayList<Integer>>();
        max=0;
        traversal(root,1);
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=1;i<=max;++i)
            ans.addAll(map.get(i));
        return ans;
    }

    public void traversal(TreeNode root, int level){
        if(root==null) return;
        max=Math.max(max,level);
        if(map.get(level)==null){
            ArrayList<Integer> l=new ArrayList<Integer> ();
            l.add(root.val);
            map.put(level, l);
        }
        else
            map.get(level).add(root.val);
        traversal(root.left,level+1);
        traversal(root.right,level);
    }
}
