package revision;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
public class Tree_lc_level_order {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        levelOrderInner(root, list, 0);
        return list;
    }

    public void levelOrderInner(TreeNode root, List<List<Integer>> list, int i) {
        if (root == null) {
            return;
        }
        if (list.size() == i) {
            list.add(new ArrayList<Integer>());
        }
        list.get(i).add(root.val);
        levelOrderInner(root.left, list, i+1);
        levelOrderInner(root.right, list, i+1);
    }
}
