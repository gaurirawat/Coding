package IB;

import java.util.*;
//https://www.interviewbit.com/problems/bst-iterator/
public class Tree_ib_binary_iterator {
    Deque<TreeNode> q;
    public Tree_ib_binary_iterator(TreeNode root) {
        q=new LinkedList<TreeNode>();
        while(root!=null){
            q.addFirst(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(q.size()==0)
            return false;
        else
            return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode sm=q.pollFirst();
        int x=sm.val;
        sm=sm.right;
        while(sm!=null){
            q.addFirst(sm);
            sm=sm.left;
        }
        return x;
    }
}
