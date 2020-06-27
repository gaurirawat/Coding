package revision;

public class Tree_lc_sumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
        return innerSumOfLeftLeaves(root,false);
    }
    
    public int innerSumOfLeftLeaves(TreeNode root, boolean isLeftNode){
        if(root == null)
            return 0;
        else if(root.left ==null && root.right== null)
            if(isLeftNode)
                return root.val;
        return innerSumOfLeftLeaves(root.left, true) +innerSumOfLeftLeaves(root.right, false);
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
}