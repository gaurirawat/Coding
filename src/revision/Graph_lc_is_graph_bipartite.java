package revision;

//bipartite graph is a graph that can be divided into two sets where every element from one set are connected(if at all)
//to elements of another set and not their own

//https://leetcode.com/problems/is-graph-bipartite/
public class Graph_lc_is_graph_bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colour= new int[graph.length];
        for(int i=0;i<graph.length;++i) {
            if(colour[i]==0 && !dfsColouringValid(i, true,graph,colour)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfsColouringValid(int u, boolean colour1, int[][] g, int[] colour) {
        colour[u]=colour1?1:2;
        for(int v:g[u]) {
            if(colour[v]==(colour1?1:2)) {
                return false;
            }
            if(colour[v]==0 && !dfsColouringValid(v,!colour1, g, colour)) {
                return false;
            }
        }
        return true;
    }
}
