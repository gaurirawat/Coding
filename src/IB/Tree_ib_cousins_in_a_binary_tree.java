package IB;

import java.util.*;
//https://www.interviewbit.com/problems/cousins-in-binary-tree/
public class Tree_ib_cousins_in_a_binary_tree {
    public ArrayList<Integer> solve(TreeNode root, int k) {
        Deque<TreeNode> currQueue = new LinkedList<TreeNode> ();
        Deque<TreeNode> nextQueue = new LinkedList<TreeNode> ();
        currQueue.add(root);
        TreeNode parent = null;

        while(!currQueue.isEmpty()) {
            TreeNode node = currQueue.pollFirst();

            if (node.left!=null) {
                nextQueue.addLast(node.left);
                if (node.left.val==k) {
                    parent = node;
                }
            }
            if (node.right!=null) {
                nextQueue.addLast(node.right);
                if (node.right.val==k) {
                    parent = node;
                }
            }

            if(currQueue.isEmpty()) {
                if (parent!=null) {
                    break;
                }
                else {
                    currQueue = nextQueue;
                    nextQueue = new LinkedList<TreeNode> ();
                }
            }
        }

        if (parent.left!=null) {
            nextQueue.remove(parent.left);
        }
        if (parent.right!=null) {
            nextQueue.remove(parent.right);
        }

        ArrayList<Integer> ans = new ArrayList<Integer> ();
        for(TreeNode temp: nextQueue) {
            ans.add(temp.val);
        }
        return ans;
    }
}