package revision;

//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
//https://leetcode.com/problems/invert-binary-tree/
public class Tree_lc_invert_tree {
	   public TreeNode invertTree(TreeNode root) {
	        if(root ==null)
	            return root;
	        TreeNode node=invertTree(root.left);
	        root.left=invertTree(root.right);
	        root.right=node;
	        return root;
	    }
}
