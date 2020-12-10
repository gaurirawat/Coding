package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/path-in-directed-graph/
public class Graph_ib_path_in_a_directed_graph {
    public int solve(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> g= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;++i) {
            g.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edge.length;++i){
            g.get(edge[i][0]-1).add(edge[i][1]-1);
        }
        boolean[] visited=new boolean[n];
        return dfs(g, visited, 0)?1:0;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>>g, boolean[] visited, int u) {
        if(u==visited.length-1){
            return true;
        }
        visited[u]=true;
        for(int x:g.get(u)){
            if(!visited[x] && dfs(g,visited, x)){
                return true;
            }
        }
        return false;
    }
}
