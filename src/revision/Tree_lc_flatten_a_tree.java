package revision;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class Tree_lc_flatten_a_tree {
    public void flatten(TreeNode root) {
        if(root==null)return;
        if(root.left==null){
            flatten(root.right);
            return;
        }
        TreeNode LSTlargest=root.left;
        while(LSTlargest.right!=null)
            LSTlargest=LSTlargest.right;
        LSTlargest.right=root.right;
        root.right=root.left;
        root.left=null;
        flatten(root.right);
    }
}
