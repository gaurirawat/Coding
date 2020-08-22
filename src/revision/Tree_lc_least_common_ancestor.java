package revision;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class Tree_lc_least_common_ancestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode A, TreeNode B, TreeNode C) {
        ans=null;
        lcaInner(A,B,C);
        return ans;
    }

    public boolean lcaInner(TreeNode root, TreeNode a, TreeNode b){
        if(root==null) return false;
        if(a==b && root==a){
            ans=root;
            return true;
        }

        boolean l=false,r=false,curr=false;
        curr= root==a||root==b;
        l=lcaInner(root.left,a,b);
        if(ans==null){
            r=lcaInner(root.right,a,b);
            if(ans==null && ((l&&r) || (curr&&l) || (curr&&r) )){
                ans=root;
            }
        }

        return curr||l||r;
    }
}

/*
Given below soln is also nice
TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return null;
        TreeNode l=helper(root.left,p,q);
        TreeNode r=helper(root.right,p,q);
        if((l!=null&&r!=null)||((root==p||root==q)&&(l!=null||r!=null)))ans=root;
        if(root==p||root==q)return root;
        return l==null&&r==null? null:root;
    }
*/