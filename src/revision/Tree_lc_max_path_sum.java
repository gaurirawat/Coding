package revision;
//The trick about this question is that path need not be calculated from a leaf node to another.
// It can be just from one root to another even if both are internal nodes. This is possible if child nodes are -ve valued.

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class Tree_lc_max_path_sum {
    static int sum=0;
	public int maxPathSum(TreeNode root) {
        sum= Integer.MIN_VALUE;
        innerPathSum(root);
        return sum;
    }

     public int innerPathSum(TreeNode node){
    	if(node == null)
    		return 0;
		int l=Math.max(0,innerPathSum(node.left));
		int r=Math.max(0,innerPathSum(node.right));
		if(l+r + node.val> sum)
			sum = l+r+ node.val;
		return Math.max(l,r)+node.val; 
    }
}

//
//class TreeNode {
//	      int val;
//	      TreeNode left;
//	      TreeNode right;
//	      TreeNode() {}
//	      TreeNode(int val) { this.val = val; }
//	      TreeNode(int val, TreeNode left, TreeNode right) {
//	          this.val = val;
//	          this.left = left;
//	          this.right = right;
//	      }
// }