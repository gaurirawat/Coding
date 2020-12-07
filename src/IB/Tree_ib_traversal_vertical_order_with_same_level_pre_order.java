package IB;

import java.util.*;
//https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
/*
Point to be kept in mind is that do not go for the recursive approach because the preorder criteria for same level does
not get fulfilled. Go for the iterative approach only/
 */
public class Tree_ib_traversal_vertical_order_with_same_level_pre_order {
    HashMap<Integer, ArrayList<Integer>> map;
    int hmin,hmax;

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans =new ArrayList<ArrayList<Integer>>();
        if(root==null) return ans;
        map=new HashMap<Integer,ArrayList<Integer>>();
        hmin=Integer.MAX_VALUE;
        hmax=Integer.MIN_VALUE;
        verticalInner(root);
        for(int i=hmin;i<=hmax;++i)
            ans.add(map.get(i));
        return ans;
    }

    public void verticalInner(TreeNode root){
        Deque<Node> q= new LinkedList<Node>();
        q.add(new Node(root,0));
        while(q.size()!=0){
            Node curr=q.pollFirst();
            hmin=Math.min(hmin,curr.h);
            hmax=Math.max(hmax,curr.h);

            if(map.get(curr.h)==null){
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(curr.root.val);
                map.put(curr.h,l);
            }
            else
                map.get(curr.h).add(curr.root.val);
            if(curr.root.left!=null) q.add(new Node(curr.root.left, curr.h-1));
            if(curr.root.right!=null) q.add(new Node(curr.root.right, curr.h+1));
        }
    }
}
class Node{
    TreeNode root;
    int h;
    public Node(TreeNode root, int y){
        this.root=root;
        h=y;
    }
}
