package SupportMaterial.DataStructureImplementation;

public class BST_impl_generic<T extends Comparable<T>> {
     TreeNode<T> root;

    public void inorder(TreeNode<T> root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public TreeNode<T> insert(T t, TreeNode<T> root) {
        if(root==null){
            return new TreeNode<T>(t);
        }
        if(t.compareTo(root.val)<0) {
            root.left=insert(t,root.left);
        } else{
            root.right=insert(t,root.right);
        }
        return root;
    }

    public TreeNode<T> delete(T t, TreeNode<T> root) {
        if(root==null) {
            return null;
        }
        if(t.compareTo(root.val)<0) {
            root.left=delete(t,root.left);
        }
        else if (t.compareTo(root.val)>0){
            root.right=delete(t,root.right);
        }
        else{
            if(root.left==null) {
                return root.right;
            }
            if(root.right==null) {
                return root.left;
            }
            TreeNode<T> inorderSuccessor=getInorderSuccessor(root.right);
            root.val=inorderSuccessor.val;
            root.right=delete(inorderSuccessor.val,root);
        }
        return root;
    }

    public TreeNode<T> getInorderSuccessor(TreeNode root){
        while(root.left!=null) {
            root=root.left;
        }
        return root;
    }
}
class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(T val) {
        this.val = val;
    }

    TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

