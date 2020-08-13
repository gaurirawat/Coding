package IB;

import java.util.Arrays;
//https://leetcode.com/problems/recover-binary-search-tree/submissions/
//https://www.interviewbit.com/problems/recover-binary-search-tree/

/*
whenever revising, revise the leetcode problem, This problem is a bit incomplete
 */
public class Tree_ib_recover_binary_tree {
    TreeNode prev, a, b, c;//wrong nodes
    public int[] recoverTree(TreeNode root) {
        prev=a=b=c=null;
        inorder(root);
        // System.out.println(a.val+" "+b.val+" "+c.val);
        int arr[]=new int[2];
        arr[0]=a.val;
        arr[1]=b.val;
        if(c!=null)
            arr[1]=c.val;
        Arrays.sort(arr);
        return arr;
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
}
