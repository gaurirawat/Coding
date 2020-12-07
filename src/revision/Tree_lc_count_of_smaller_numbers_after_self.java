package revision;
import java.util.*;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/
public class Tree_lc_count_of_smaller_numbers_after_self {

    class CountTreeNode{
        int val;
        int dup;
        int count;
        CountTreeNode left;
        CountTreeNode right;
        public CountTreeNode(int i) {
            val=i;
            dup=1;
            count=1;
            left=null;
            right=null;
        }
    }

    List<Integer> l;
    public List<Integer> countSmaller(int[] nums) {
        l=new ArrayList<Integer>();
        if(nums.length==0) {
            return l;
        }
        CountTreeNode root=null;
        for(int i=nums.length-1;i>=0;--i) {
            root=insert(root,nums[i],0);
        }
        Collections.reverse(l);
        return l;
    }

    public CountTreeNode insert(CountTreeNode root, int val, int sum) {
        if(root==null) {
            // l.add(new Integer(sum));
            l.add(sum);
            return new CountTreeNode(val);
        }
        if(root.val==val) {
            sum+=root.left==null?0:root.left.count;
            l.add(sum);
            root.dup++;
        }
        else if (root.val<val) {
            sum+=root.count-(root.right==null?0:root.right.count);
            root.right=insert(root.right, val, sum);
        }
        else {
            root.left=insert(root.left, val, sum);
        }
        root.count++;
        return root;
    }
}
