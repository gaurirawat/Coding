package IB;

import java.util.ArrayList;

public class Tree_ib_zigzag_level_order_traversal_bt {
    ArrayList<ArrayList<Integer>> l;
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        l=new  ArrayList<ArrayList<Integer>>();
        zigzagInner(root, 0);
        return l;
    }

    public void zigzagInner(TreeNode root, int level){
        if(root==null) return;
        if(level==l.size()){
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.add(root.val);
            l.add(t);
        }
        else{
            if(level%2==0)
                l.get(level).add(root.val);
            else
                l.get(level).add(0,root.val);
        }
        zigzagInner(root.left,level+1);
        zigzagInner(root.right,level+1);
    }
}
