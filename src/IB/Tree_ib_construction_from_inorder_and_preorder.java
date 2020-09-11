package IB;

import java.util.*;
//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
public class Tree_ib_construction_from_inorder_and_preorder {
    int i;
    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        if(in.size()==0) return null;
        i=0;
        return build(pre, in,0,pre.size()-1);
    }

    public TreeNode build(ArrayList<Integer> pre, ArrayList<Integer> in, int l, int r){
        if(i==in.size()||l>r) return null;
        int pos=search(pre.get(i),in,l,r);
        TreeNode root=null;
        if(l<=pos&&pos<=r){
            root=new TreeNode(pre.get(i));
            ++i;
            root.left=build(pre,in,l,pos-1);
            root.right=build(pre,in,pos+1,r);
        }
        return root;
    }

    public int search(int n, ArrayList<Integer> in, int l, int r){
        if(l==r && in.get(l)==n) return l;
        for(int i=l;i<=r;++i)
            if(in.get(i)==n)
                return i;
        return -1;
    }
}