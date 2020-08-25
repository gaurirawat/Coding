package IB;

import java.util.*;
//https://www.interviewbit.com/problems/cousins-in-binary-tree/
public class Tree_ib_cousins_in_a_binary_tree {
    public ArrayList<Integer> solve(TreeNode a, int n) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(a.val==n) return ans;

        Pair foundN=null;
        Deque<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(a,null,1));
        int currL=0;
        while(q.size()!=0){
            Pair p=q.pollFirst();
            if(currL!=p.level){
                if(foundN==null){
                    ans.clear();
                    currL=p.level;
                }
                else{
                    break;
                }
            }
            if(p.root.val==n)
                foundN=p;
            ans.add(p.root.val);
            if(p.root.left!=null) q.addLast(new Pair(p.root.left,p.root,p.level+1));
            if(p.root.right!=null) q.addLast(new Pair(p.root.right,p.root,p.level+1));
        }
        if(foundN.parent.left!=null && ans.contains(foundN.parent.left.val))
            ans.remove(new Integer(foundN.parent.left.val));
        if(foundN.parent.right!=null && ans.contains(foundN.parent.right.val))
            ans.remove(new Integer(foundN.parent.right.val));
        return ans;
    }
}
class Pair{
    TreeNode root;
    TreeNode parent;
    int level;
    public Pair(TreeNode r, TreeNode p,int l){
        root=r;
        parent=p;
        level=l;
    }
}