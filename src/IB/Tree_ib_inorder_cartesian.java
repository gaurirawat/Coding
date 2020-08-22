package IB;
//https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/

public class Tree_ib_inorder_cartesian {
    public TreeNode buildTree(int[] a) {
        return buildInner(0,a.length-1,a);
    }

    public TreeNode buildInner(int l, int r, int[]arr){
        if(l>r) return null;
        int mxp=l;
        for(int i=l; i<=r;++i)
            if(arr[mxp]<arr[i])
                mxp=i;
        TreeNode root=new TreeNode(arr[mxp]);
        root.left=buildInner(l,mxp-1,arr);
        root.right=buildInner(mxp+1,r,arr);
        return root;
    }
}
