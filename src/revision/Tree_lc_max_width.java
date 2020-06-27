package revision;
// https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/

import java.util.*;
public class Tree_lc_max_width {

	class modTreeNode{
		TreeNode node;
		int index;
		int level;
		public modTreeNode(TreeNode a,int b,int c){
			node=a;
			index=b;
			level=c;
		}
	}

	 public int widthOfBinaryTree(TreeNode root) {
	 	if(root==null) return 0;
		Queue<modTreeNode> q= new LinkedList<modTreeNode>();
        q.add(new modTreeNode(root, 1,1));
        int maxW=1;
        int minI=1;
        int maxI=1;
        int prLevel=0;
        while(q.size()!=0){
        	modTreeNode tmp= q.poll();
        	if(prLevel!=tmp.level){
        		maxW= maxI!=minI? Math.max(maxW, maxI-minI+1): maxW;
        		minI= tmp.index;
        		maxI= tmp.index;
        		prLevel=tmp.level;
        	}
        	else{
        		minI=Math.min(minI, tmp.index);
        		maxI=Math.max(maxI, tmp.index);
        	}
        	if(tmp.node.left!=null)
        		q.add(new modTreeNode(tmp.node.left, tmp.index*2, tmp.level+1));
        	if(tmp.node.right!=null)
        		q.add(new modTreeNode(tmp.node.right, tmp.index*2+1, tmp.level+1));
        }
        maxW= maxI!=minI? Math.max(maxW, maxI-minI+1): maxW;
        return maxW;
    }
}