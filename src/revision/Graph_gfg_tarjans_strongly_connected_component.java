package revision;

import java.util.*;
// Ref: https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
//Ref: https://www.youtube.com/watch?v=TyWtx7q2D7Y
//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
public class Graph_gfg_tarjans_strongly_connected_component {
    int c;
    int scc;
    public int kosaraju(ArrayList<ArrayList<Integer>> g, int n)
    {
        c=1;
        scc=0;
        int low[]=new int[n];
        int d[]=new int[n];
        boolean instack[]=new boolean[n];
        Deque<Integer> st=new LinkedList<Integer>();
        for(int i=0;i<n;++i){
            if(d[i]==0)
                dfs(i,g,st,low,d,instack);
        }
        return scc;
    }

    public void dfs(int u, ArrayList<ArrayList<Integer>> g, Deque<Integer> st,int low[], int d[], boolean instack[]){
        d[u]=low[u]=c++;
        st.addFirst(u);
        instack[u]=true;
        for(int v:g.get(u)){
            if(d[v]==0){
                dfs(v,g,st,low,d, instack);
                low[u]=Math.min(low[v], low[u]);
            }
            else if(instack[v]== true)
                low[u]= Math.min(low[u], d[v]);
        }
        if(d[u]==low[u]){
            ++scc;
            while(st.peekFirst()!=u)
                instack[st.pollFirst()]=false;
            instack[st.pollFirst()]=false;
        }
    }
}
