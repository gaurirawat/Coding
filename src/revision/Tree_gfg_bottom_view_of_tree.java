package revision;
//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

import java.util.*;

public class Tree_gfg_bottom_view_of_tree {
    int minHd;
    int maxHd;
    class TwoInt{
        int ht;
        int val;
        public TwoInt(int x, int y){
            this.ht=x; this.val=y;
        }
    }

    // Method that returns the bottom view.
    public ArrayList<Integer> bottomView(Node root)
    {
        minHd=Integer.MAX_VALUE;
        maxHd=Integer.MIN_VALUE;
        HashMap<Integer,TwoInt> map= new HashMap<Integer,TwoInt>();
        bottomViewInner(root, 0,1,map);

        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=minHd;i<=maxHd;++i)
            ans.add(map.get(i).val);
        return ans;
    }

    public void bottomViewInner(Node root, int hd, int ht, HashMap<Integer,TwoInt> map){
        if(root==null) return;
        minHd=Math.min(minHd,hd);
        maxHd=Math.max(maxHd,hd);

        if(map.containsKey(hd)==false)
            map.put(hd,new TwoInt(ht,root.data));
        else if(map.get(hd).ht<ht)
            map.put(hd,new TwoInt(ht,root.data));

        bottomViewInner(root.right,hd+1,ht+1,map);
        bottomViewInner(root.left, hd-1,ht+1,map);

    }

     class Node
     {
         int data; //data of the node
         int hd; //horizontal distance of the node
         Node left, right; //left and right references

         // Constructor of tree node
         public Node(int key)
         {
             data = key;
             hd = Integer.MAX_VALUE;
             left = right = null;
         }
     }
}
