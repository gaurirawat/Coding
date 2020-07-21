package revision;
/*
Topological Sorting of a graph. In DFS, we start from a vertex, we first print it and then recursively call DFS for its
adjacent vertices. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first
recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of
stack. Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so
on) are already in stack.
 */
//https://practice.geeksforgeeks.org/problems/topological-sort/1

import java.util.*;

public class Graph_gfg_topological_sort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> g, int v) {
        boolean visited[]= new boolean[v];
        Deque<Integer> st= new LinkedList<Integer>();
        for(int i=0;i<v;++i){
            if(!visited[i])
                topologicalSortInner(i,g,visited,st);
        }
        int ans[]=new int[v];
        int c=0;
        while(st.size()!=0)
            ans[c++]=st.pollLast();
        return ans;
    }

    public static void topologicalSortInner(int v, ArrayList<ArrayList<Integer>> g, boolean[]visited, Deque<Integer> st){
        visited[v]=true;
        for(int x:g.get(v)){
            if(!visited[x])
                topologicalSortInner(x,g,visited,st);
        }
        st.addLast(v);
    }
}
