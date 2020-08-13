package revision;
//https://leetcode.com/problems/recover-binary-search-tree/submissions/
//https://www.interviewbit.com/problems/recover-binary-search-tree/

//Refer this explanation
//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

public class Tree_lc_recover_binary_tree {
    TreeNode prev, a, b, c;//wrong nodes
    public void recoverTree(TreeNode root) {
        prev=a=b=c=null;
        inorder(root);
        // System.out.println(a.val+" "+b.val+" "+c.val);
        if(c!=null)
            b=c;
        recover(root, a.val,b.val);
    }

    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);

        if(prev!=null){
            if(prev.val>root.val && a==null){
                a=prev;
                b=root;
            }
            else if(prev.val>root.val && a!=null)
                c=root;
        }
        prev=root;

        inorder(root.right);
    }

    public void recover(TreeNode root, int a, int b){
        if(root==null) return;
        if(root.val==a) root.val=b;
        else if(root.val==b) root.val=a;
        recover(root.left,a,b);
        recover(root.right,a,b);
    }
}
