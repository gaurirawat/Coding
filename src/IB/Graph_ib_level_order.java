package IB;

import java.util.*;
//https://www.interviewbit.com/problems/level-order/
public class Graph_ib_level_order {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> l=new ArrayList<Integer>();
        Deque<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        int currLevel=0;
        while(q.size()!=0){
            Pair pair=q.pollFirst();
            if(currLevel!=pair.level){
                ans.add(l);
                l=new ArrayList<Integer>();
                currLevel=pair.level;
            }
            l.add(pair.root.val);
            if(pair.root.left!=null) q.addLast(new Pair(pair.root.left, pair.level+1));
            if(pair.root.right!=null) q.addLast(new Pair(pair.root.right, pair.level+1));
        }
        ans.add(l);
        return ans;
    }
    class Pair{
        TreeNode root;
        int level;
        public Pair(TreeNode root, int level){
            this.root=root;
            this.level=level;
        }
    }

}