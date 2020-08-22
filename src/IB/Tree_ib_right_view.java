package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/right-view-of-binary-tree/
public class Tree_ib_right_view {
    ArrayList<Integer> ans;
    public ArrayList<Integer> solve(TreeNode root) {
        ans =new ArrayList<Integer>();
        rightView(root, 0);
        return ans;
    }

    public void rightView(TreeNode root, int level){
        if(root==null) return ;
        if(level==ans.size())
            ans.add(root.val);
        rightView(root.right, level+1);
        rightView(root.left,  level+1);
    }
}
