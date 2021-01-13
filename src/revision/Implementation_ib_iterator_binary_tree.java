package revision;

import java.util.Deque;
import java.util.LinkedList;

//https://www.interviewbit.com/problems/bst-iterator/
public class Implementation_ib_iterator_binary_tree {
    Deque<TreeNode> q;
    public Implementation_ib_iterator_binary_tree(TreeNode root) {
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
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
