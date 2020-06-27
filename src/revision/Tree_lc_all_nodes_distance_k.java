package revision;

// https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1

import java.util.*;
public class Tree_lc_all_nodes_distance_k {
	
     static Map<TreeNode, TreeNode> map= new HashMap<TreeNode, TreeNode>();
    static List<Integer> list = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map.clear();
        list.clear();
        findParent(root);
        distanceKchild(target, k);
        distanceKparent(target, k);
        return list;
    }

    
    public void findParent(TreeNode node){
        if(node== null)
            return ;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(node);
        map.put(node, null);
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            if(temp.left!=null) {
                map.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right, temp);
                q.add(temp.right);
            }
        }
    }

    public void distanceKchild(TreeNode node, int k){
        if(k<0 || node==null) return;
        if(k==0) list.add(node.val);
        distanceKchild(node.left, k-1);
        distanceKchild(node.right, k-1);
    }

    public void distanceKparent(TreeNode node, int k){
        TreeNode parent=null;
        int i;
        k--;
        for(i=k; i>=0 ;--i){
            parent = map.get(node);
            if(parent==null) break;
            if(parent.left==node)
                distanceKchild(parent.right,i-1);
            else 
                distanceKchild(parent.left,i-1);
            node=parent;
        }
        if(i==-1 && parent !=null)
            list.add(parent.val);
    }
}
