package revision;
// https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/
public class Tree_lc_recursively_del_leaves_with_given_value {

	public TreeNode removeLeafNodes(TreeNode node, int target) {
     	if(node==null)
     		return null;
   
     	node.left= removeLeafNodes(node.left,target);
     	node.right= removeLeafNodes(node.right, target);

 	  	if(node.val==target && node.left==null && node.right==null)
 		return null;

     	return node;
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//