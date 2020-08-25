package IB;

import java.util.List;

//https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
public class Tree_ib_sorted_array_to_BST {
    public TreeNode sortedArrayToBST(List<Integer> arr) {
        if(arr.size()==0) return null;
        return construct(arr, 0, arr.size()-1);
    }
    public TreeNode construct(List<Integer> arr, int l, int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=construct(arr, l, mid-1);
        root.right=construct(arr, mid+1,r);
        return root;
    }
}
