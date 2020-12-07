package revision;

import java.util.*;

//https://leetcode.com/problems/delete-nodes-and-return-forest/
public class Tree_lc_delete_node_and_return_forest {
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] del) {
        ans= new ArrayList<TreeNode>();
        HashSet<Integer> delSet=new HashSet<Integer>();
        ans.add(root);
        for(int x:del) {
            delSet.add(x);
            if(x==root.val){
                ans.remove(root);
            }
        }
        delete(root, delSet);
        return ans;
    }

    public TreeNode delete(TreeNode root, HashSet<Integer> delSet) {
        if(root==null){
            return null;
        }
        root.left=delete(root.left, delSet);
        root.right=delete(root.right, delSet);

        if(delSet.contains(root.val)) {
            if(root.left!=null) {
                ans.add(root.left);
            }
            if(root.right!=null) {
                ans.add(root.right);
            }
            return null;
        }

        return root;
    }
}
