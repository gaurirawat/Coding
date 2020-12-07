package IB;

import java.util.*;
//ref:  https://www.techiedelight.com/postorder-tree-traversal-iterative-recursive/
//https://www.interviewbit.com/problems/postorder-traversal/

public class Tree_ib_traverse_postorder {
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> revAns=new ArrayList<Integer>();
        if(a==null) return revAns;
        Deque<TreeNode> st=new LinkedList<TreeNode>();
        st.add(a);
        while(st.size()!=0){
            TreeNode root=st.pollFirst();
            revAns.add(root.val);
            if(root.left!=null) st.addFirst(root.left);
            if(root.right!=null) st.addFirst(root.right);
        }
        Collections.reverse(revAns);
        return revAns;
    }
}
