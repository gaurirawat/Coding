package IB;

import java.math.BigInteger;

public class Tree_ib_sum_root_to_leaf_numbers {
    int ans;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            ans=0;
        sumNumbersInner(root, "");
        return ans;
    }

    public void sumNumbersInner(TreeNode root, String s){
        if(root==null) return;
        if(root.left==null && root.right==null){
            int n=((new BigInteger(s+root.val)).mod(new BigInteger("1003"))).intValue();
            ans=ans+n;
            ans%=1003;
            return;
        }
        sumNumbersInner(root.left,s+root.val);
        sumNumbersInner(root.right,s+root.val);
    }
}
