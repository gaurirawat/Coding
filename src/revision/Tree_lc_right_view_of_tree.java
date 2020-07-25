package revision;
//https://leetcode.com/problems/binary-tree-right-side-view/submissions/

import java.util.*;
public class Tree_lc_right_view_of_tree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer>();
        innerRightSideView(root,1, ans);
        return ans;
    }

    public void innerRightSideView(TreeNode root, int level, List<Integer> ans){
        if(root==null) return;
        if(level>ans.size())
            ans.add(root.val);
        innerRightSideView(root.right, level+1,ans);
        innerRightSideView(root.left, level+1,ans);
    }
}
