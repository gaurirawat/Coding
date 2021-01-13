package revision;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
public class Tree_lc_zigzag_level_order {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        zigzagInner(root, 0, list);
        return list;
    }

    public void zigzagInner(TreeNode root, int i, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (list.size() == i) {
            list.add(new ArrayList<Integer>());
        }
        if (i % 2 == 0) {
            list.get(i).add(root.val);
        }
        else {
            list.get(i).add(0, root.val);
        }
        zigzagInner(root.left, i + 1, list);
        zigzagInner(root.right, i + 1, list);
    }
}
