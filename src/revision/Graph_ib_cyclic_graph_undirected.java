package revision;
//https://www.interviewbit.com/problems/cycle-in-undirected-graph/

import java.util.ArrayList;

public class Graph_ib_cyclic_graph_undirected {
    public int solve(int v, int[][] g) {
        boolean visited[]= new boolean[v+1];
        boolean stack[]= new boolean[v+1];
        ArrayList<ArrayList<Integer>> gr= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v+1;++i)
            gr.add(new ArrayList<Integer>());
        for(int i=0;i<g.length;++i){
            gr.get(g[i][0]).add(g[i][1]);
        }
        for(int i=1;i<=v;++i){
            if(cyclicUndirectedInner(-1,i,gr,visited,stack))
                return 1;
        }
        return 0;
    }

    public boolean cyclicUndirectedInner(int parent, int v, ArrayList<ArrayList<Integer>> g, boolean visited[], boolean stack[]){
        if(stack[v]==true)
            return true;
        if(visited[v]==true)
            return false;
        visited[v]=true;
        stack[v]=true;
        for(Integer i: g.get(v)){
            if(i!=parent && cyclicUndirectedInner(v,i, g, visited, stack))
                return true;
        }
        stack[v]=false;
        return false;
    }
}
