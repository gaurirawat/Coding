package revision;

import java.util.*;

// https://leetcode.com/problems/binary-tree-right-side-view/submissions/
public class Tree_lc_right_view {
 static List<Integer> list= new ArrayList<Integer>();
	
	public List<Integer> rightSideView(TreeNode root) {
        list.clear();
        innerRightSideView(root, 1);
        return list;
    }

    public void innerRightSideView(TreeNode node, int k){
    	if(node ==null) return;
    	if(k>list.size()) 
    		list.add(node.val);
		innerRightSideView(node.right, k+1);
    	innerRightSideView(node.left, k+1);
    }
}
