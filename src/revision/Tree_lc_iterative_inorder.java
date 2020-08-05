package revision;

import java.util.*;
//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
//https://www.interviewbit.com/problems/inorder-traversal/

public class Tree_lc_iterative_inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> st= new LinkedList<TreeNode>();
        ArrayList<Integer> l= new ArrayList<Integer>();
        while(root!=null){
            st.addLast(root);
            root=root.left;
        }
        while(st.size()!=0){
            TreeNode node = st.pollLast();
            l.add(node.val);
            node=node.right;
            while(node!=null){
                st.addLast(node);
                node=node.left;
            }
        }
        return l;
    }
}
