package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/delete-edge/
public class Graph_ib_delete_edge {
    long max=0;
    int totSum=0;
    public int deleteEdge(int[] wt, int[][] edges) {
        totSum=0;
        max=0;
        ArrayList<ArrayList<Integer>> g= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<wt.length;++i){
            totSum+=wt[i];
            g.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;++i){
            g.get(edges[i][0]-1).add(edges[i][1]-1);
            g.get(edges[i][1]-1).add(edges[i][0]-1);
        }

        findMaxProd(0,-1, g, wt);
        // int mod=(int)Math.pow(10,9)+7;
        return (int)(max);
    }

    public int findMaxProd(int u, int parent, ArrayList<ArrayList<Integer>> g, int[]wt){
        int mod=(int)Math.pow(10,9)+7;
        int subTreeSum=0;
        for(int v: g.get(u)){
            if(v!=parent){
                int edgeSum=findMaxProd(v, u, g, wt);
                if(max<((1l*edgeSum*(totSum-edgeSum))%mod))
                    max=(1l*edgeSum*(totSum-edgeSum))%mod;
                subTreeSum+=edgeSum;
            }
        }
        return subTreeSum+wt[u];
    }
}
