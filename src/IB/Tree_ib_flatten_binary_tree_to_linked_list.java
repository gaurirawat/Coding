package IB;
//https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
public class Tree_ib_flatten_binary_tree_to_linked_list {
    public TreeNode flatten(TreeNode root) {
        if(root==null) return root;
        if(root.left!=null){
            TreeNode temp=root.left;
            while(temp.right!=null)
                temp=temp.right;
            temp.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        flatten(root.right);
        return root;
    }
}
