package revision;
// https://leetcode.com/problems/diameter-of-binary-tree/submissions/
public class Tree_lc_diameter {
	static int sum=0;
	public int diameterOfBinaryTree(TreeNode node) {
        sum=0;
        innerDiameter(node);
        return sum;
    }

    public int innerDiameter(TreeNode node){
    	if(node == null)
    		return 0;
		int l=innerDiameter(node.left);
		int r=innerDiameter(node.right);
		if(l+r> sum)
			sum = l+r;
		return Math.max(l,r)+1; 
    }
}

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