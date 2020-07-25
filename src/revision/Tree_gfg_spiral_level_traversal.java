package revision;
//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1

import java.util.*;

public class Tree_gfg_spiral_level_traversal {
    void printSpiral(Node node)
    {
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        printSpiralInner(node,1,ans);
        for(ArrayList<Integer> l:ans){
            for(int x:l)
                System.out.print(x+" ");
        }
    }

    public void printSpiralInner(Node root, int level, ArrayList<ArrayList<Integer>> ans){
        if(root==null) return;
        if(level>ans.size()){
            ArrayList<Integer> l= new ArrayList<Integer>();
            l.add(root.data);
            ans.add(l);
        }
        else if(level%2==0)
            ans.get(level-1).add(root.data);
        else
            ans.get(level-1).add(0,root.data);
        printSpiralInner(root.left,level+1,ans);
        printSpiralInner(root.right,level+1,ans);
    }
}
