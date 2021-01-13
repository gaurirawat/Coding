package revision;

import java.util.HashMap;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
public class Tree_lc_construct_using_preorder_and_inorder {
    int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            index.put(inorder[i], i);
        }
        i = 0;
        return buildInner(preorder, index, 0, preorder.length - 1);
    }

    public TreeNode buildInner(int[] preorder, HashMap<Integer, Integer> index , int l, int r) {
        if (l > r) {
            return null;
        }
        int nextNodeIndex = index.get(preorder[i]);
        if (nextNodeIndex < l || nextNodeIndex > r) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = buildInner(preorder, index, l, nextNodeIndex - 1);
        node.right = buildInner(preorder, index, nextNodeIndex + 1, r);
        return node;
    }
}
