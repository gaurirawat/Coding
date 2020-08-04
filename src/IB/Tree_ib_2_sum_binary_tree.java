package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/2sum-binary-tree/
/*absolute stupid solution*/
public class Tree_ib_2_sum_binary_tree {
    public int t2Sum(TreeNode a, int k) {
        if(a==null) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(a,list);
        int l=0,r=list.size()-1;
        while(l<r){
            int sum=list.get(l)+list.get(r);
            if(sum==k)
                return 1;
            else if(sum<k)
                ++l;
            else
                --r;
        }
        return 0;
    }

    public void inorder(TreeNode root, ArrayList<Integer> l){
        if(root ==null) return;
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }

}
