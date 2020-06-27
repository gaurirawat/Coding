package revision;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
// check soln : https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/643054/100-Faster-Java-Code
public class BST_lc_Kth_smallest {
	 String ans=null;
	public int kthSmallest(TreeNode root, int k) {
        ans= null;
        innerKthSmallest(root, k);
        return Integer.parseInt(ans);
    }

    public int innerKthSmallest(TreeNode root, int k){   	
    	if(root==null)
    		return 0;
        int x= innerKthSmallest(root.left, k)+1;
    	if(k-x==0)
    		ans= root.val+"";
        if(ans!=null)
    		return -999;
        else
		    return x+ innerKthSmallest(root.right, k-x);
    }
}
