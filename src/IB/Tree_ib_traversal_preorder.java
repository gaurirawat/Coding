package IB;

import java.util.*;

//https://www.interviewbit.com/problems/preorder-traversal/
public class Tree_ib_traversal_preorder {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans= new ArrayList<Integer>();
        if(root==null) return ans;
        Deque<TreeNode> st= new LinkedList<TreeNode>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode node=st.pollFirst();
            ans.add(node.val);
            if(node.right!=null)
                st.addFirst(node.right);
            if(node.left!=null)
                st.addFirst(node.left);
        }
        return ans;
    }
}