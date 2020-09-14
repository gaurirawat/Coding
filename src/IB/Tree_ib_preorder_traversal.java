package IB;

import java.util.*;

//https://www.interviewbit.com/problems/preorder-traversal/
public class Tree_ib_preorder_traversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans= new ArrayList<Integer>();
        if(root==null) return ans;
        Deque<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.pollFirst();
            ans.add(node.val);
            if(node.right!=null)
                q.addFirst(node.right);
            if(node.left!=null)
                q.addFirst(node.left);
        }
        return ans;
    }
}