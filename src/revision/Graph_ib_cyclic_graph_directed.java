package revision;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/cycle-in-undirected-graph/
public class Graph_ib_cyclic_graph_directed {
    public int solve(int v, int[][] g) {
        boolean visited[]= new boolean[v+1];
        boolean stack[]= new boolean[v+1];
        for(int i=1; i<=v; ++i){
            if(innerIsCyclic(i,g, visited,stack))
                return 1;
        }
        return 0;
    }

    public boolean innerIsCyclic(int x, int[][] g, boolean visited[],boolean stack[]){
        if(stack[x])
            return true;
        if(visited[x])
            return false;
        stack[x]= true;
        visited[x]= true;
        for(int i=0;i<g.length;++i){
            if(g[i][0]==x && innerIsCyclic(g[i][1], g, visited, stack))
                return true;
        }
        stack[x]= false;
        return false;
    }
}
