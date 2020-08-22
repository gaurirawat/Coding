package IB;
//https://www.interviewbit.com/problems/least-common-ancestor/

//checkout leetcode solution: Tree_lc_least_common_ancestor

public class Tree_ib_least_common_ancestor {
    int ans;

    public int lca(TreeNode A, int B, int C) {
        ans=-1;
        lcaInner(A,B,C);
        return ans;
    }

    public boolean lcaInner(TreeNode root, int a,int b){
        if(root==null) return false;
        if(a==b && root.val==a){
            ans=a;
            return true;
        }
        boolean l=false,r=false,curr=false;
        curr=root.val==a||root.val==b;
        l=lcaInner(root.left,a,b);
        if(ans==-1){
            r=lcaInner(root.right,a,b);
            if(ans==-1 && ((l&&r) || (curr&&l) || (curr&&r) )){
                ans=root.val;
            }
        }

        return curr||l||r;
    }
}