package revision;

//https://leetcode.com/problems/binary-tree-tilt/submissions/
public class Tree_lc_tilt_of_bt {
	
	static int sum=0;
    public int findTilt(TreeNode root) {
        sum=0;
		tiltInner(root);
		return sum;
    }

	public int tiltInner(TreeNode root) {
		if(root== null)
			return 0;
		int l= tiltInner(root.left);
		int r= tiltInner(root.right);
		sum+= Math.abs(l-r);
		return l+r+ root.val;
	}
}
