package revision;

import java.util.*;

public class Tree_lc_find_duplicate_subtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, ArrayList<TreeNode>> map = new HashMap<String, ArrayList<TreeNode>>();
        findDuplicateInner(root, map);

        ArrayList<TreeNode> answer = new ArrayList<TreeNode>();
        for (Map.Entry<String, ArrayList<TreeNode>> e : map.entrySet()) {
            answer.add(e.getValue().get(0));
        }
        return answer;
    }

    public String findDuplicateInner(TreeNode root, HashMap<String, ArrayList<TreeNode>> map) {
        if(root == null) {
            return "N";
        }

        StringBuffer sb = new StringBuffer(root.val+ "-");
        sb.append(findDuplicateInner(root.left, map)+ "-");
        sb.append(findDuplicateInner(root.right, map)+ "-");
        String s = sb.toString();
        if (map.get(s) != null) {
            map.get(s).add(root);
        }
        else {
            ArrayList<TreeNode> l = new ArrayList<TreeNode>();
            l.add(root);
            map.put(s, l);
        }
        return s;
    }
}
