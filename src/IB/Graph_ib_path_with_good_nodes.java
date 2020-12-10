package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/path-with-good-nodes/
public class Graph_ib_path_with_good_nodes {
    int ans;
    int k;
    public int solve(int[] good, int[][] edge, int K) {
        ArrayList<ArrayList<Integer>> g= new ArrayList<ArrayList<Integer>> ();
        for(int i=0;i<good.length;++i){
            g.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edge.length;++i) {
            g.get(edge[i][0]-1).add(edge[i][1]-1);
            g.get(edge[i][1]-1).add(edge[i][0]-1);
        }
        ans=0;
        k=K;
        traverseTree(0,-1, 0,good, g);
        return ans;
    }

    public void traverseTree(int i, int parent, int c, int[] good, ArrayList<ArrayList<Integer>> g) {
        if(good[i]==1){
            c++;
        }
        if(g.get(i).size()==1 && g.get(i).get(0)==parent && c<=k){
            ans++;
            return;
        }
        for(int x:g.get(i)){
            if(x!=parent){
                traverseTree(x,i, c, good, g);
            }
        }
    }
}
