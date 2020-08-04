package IB;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
public class Tree_ib_kth_smallest_element {
    int ans;
    boolean isFound;
    public int kthsmallest(TreeNode A, int k) {
        ans=0;
        isFound=false;
        kthSmallestInner(A,k);
        return ans;
    }
/*
simple logic. calc no of elements in each subtree recursively and keep track of the answer globally.
 */
    public int kthSmallestInner(TreeNode a, int k){
        if(a==null) return 0;
        int l=kthSmallestInner(a.left,k);
        if(!isFound && l+1==k){
            ans=a.val;
            isFound=true;
        }
        int r=0;
        if(!isFound)
            r=kthSmallestInner(a.right,k-l-1);
        return l+r+1;
    }
}
