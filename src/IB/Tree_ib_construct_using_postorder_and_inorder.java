package IB;

import java.util.*;
//https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/
public class Tree_ib_construct_using_postorder_and_inorder {
    int c;
    public TreeNode buildTree(ArrayList<Integer> io, ArrayList<Integer> po){
        if(io==null||io.size()==0) return null;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<io.size();++i)
            map.put(io.get(i),i);
        c=io.size()-1;
        return buildTreeInner(map,po,0,io.size()-1);
    }
    public TreeNode buildTreeInner(HashMap<Integer,Integer> io, ArrayList<Integer> po, int li, int ui){
        if(po.size()==0)return null;
        int x=po.get(po.size()-1);
        TreeNode root =null;
        int pos=io.get(x);
        if(pos>=li && pos<=ui){
            root= new TreeNode(x);
            po.remove(po.size()-1);
            root.right=buildTreeInner(io,po,pos+1,ui);
            root.left=buildTreeInner(io,po,li,pos-1);
        }
        return root;
    }
}
/*
int c;
    public TreeNode buildTree(int[] in, int[] post) {
        if(in.length==0) {
            return null;
        }
        c=in.length-1;
        return buildTreeInner(0, in.length-1, in, post);
    }

    public TreeNode buildTreeInner(int l, int r, int[] in, int[] post) {
        if(l>r) {
            return null;
        }
        TreeNode curr=new TreeNode(post[c--]);
        int index = findIndex(in, l, r, curr.val);
        curr.right = buildTreeInner(index+1, r, in, post);
        curr.left = buildTreeInner(l, index-1, in, post);
        return curr;
    }

    public int findIndex(int[] nums, int l, int r, int val) {
        while(l<=r) {
            if(nums[l]==val) {
                return l;
            }
            l++;
        }
        return 1;
    }
 */
