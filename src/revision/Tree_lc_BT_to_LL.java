package revision;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class Tree_lc_BT_to_LL {

	public void flatten(TreeNode node) {
    	if(node==null)
    		return;
		
    	if(node.left==null){
    		flatten(node.right);
            return ;
        }

		TreeNode lLargest= node.left;
		while(lLargest.right!=null)
    		lLargest=lLargest.right;
    	lLargest.right= node.right;

    	node.right=node.left;
    	node.left=null;
    	flatten(node.right);
    }
}