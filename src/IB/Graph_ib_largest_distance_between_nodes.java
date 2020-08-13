package IB;

import java.util.*;

//https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
public class Graph_ib_largest_distance_between_nodes {
    int depth;
    public int solve(ArrayList<Integer> a) {
        if(a==null||a.size()==0)return 0;
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<Integer, ArrayList<Integer>>();
        int root=0;
        for(int i=0;i<a.size();++i){
            if(a.get(i)==-1)
                root=i;
            else if(map.get(a.get(i))==null){
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                map.put(a.get(i),l);
            }
            else{
                map.get(a.get(i)).add(i);
            }
        }
        // System.out.println(map.toString());
        depth=0;
        depthDFS(root, map);
        return depth;
    }

    public int depthDFS(int i, HashMap<Integer, ArrayList<Integer>> map){
        int max1=0, max2=0;
        if(map.get(i)==null)
            return 1;
        ArrayList<Integer> child=map.get(i);
        for(int x:child){
            int t=depthDFS(x, map);
            if(t>=max1){
                max2=max1;
                max1=t;
            }
            else if(t>=max2){
                max2=t;
            }
        }
        depth=Math.max(depth, max1+max2);
        return Math.max(max1, max2)+1;
    }
}
