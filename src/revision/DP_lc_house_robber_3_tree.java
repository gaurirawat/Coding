package revision;
//https://leetcode.com/problems/house-robber-iii/
public class DP_lc_house_robber_3_tree {
    public int rob(TreeNode root) {
        int[] arr = robInner(root);
        return Math.max(arr[0], arr[1]);
    }

    public int[] robInner(TreeNode root) {
        int[] money = new int[2];
        if (root == null) {
            return money;
        }
        int[] left = robInner(root.left);
        int[] right = robInner(root.right);
        money[0] = left[1] + right[1] + root.val;
        money[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // System.out.println(root.val + " "+ money[0] + " " + money[1]);
        return money;
    }
}
