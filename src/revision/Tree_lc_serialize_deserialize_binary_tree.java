package revision;

import java.util.*;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/
public class Tree_lc_serialize_deserialize_binary_tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> sTree = new ArrayList<String>();
        serializeInner(root, sTree);
        return String.join(" ", sTree);
    }

    public void serializeInner(TreeNode root, ArrayList<String> sTree) {
        if(root == null) {
            sTree.add("N");
            return;
        }
        sTree.add(root.val+"");
        serializeInner(root.left, sTree);
        serializeInner(root.right, sTree);
    }

    int c;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sTree = data.split(" ");
        c = 0;
        return deserializeInner(sTree);
    }

    public TreeNode deserializeInner(String[] sTree) {
        if (sTree[c].equals("N")) {
            c++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(sTree[c++]));
        root.left = deserializeInner(sTree);
        root.right = deserializeInner(sTree);
        return root;
    }
}
