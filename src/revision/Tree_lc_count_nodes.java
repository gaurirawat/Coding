package revision;
//https://leetcode.com/problems/count-complete-tree-nodes/submissions/

public class Tree_lc_count_nodes {
	 public int countNodes(TreeNode root) {
	        if(root== null)
	            return 0;
	        else return 1+ countNodes(root.left)+ countNodes(root.right);
	    }
}
 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
 }
