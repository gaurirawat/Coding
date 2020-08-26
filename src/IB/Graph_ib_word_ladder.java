package IB;

import java.util.*;
//https://www.interviewbit.com/problems/word-ladder-i/
public class Graph_ib_word_ladder {
    public int solve(String a, String b, ArrayList<String> c) {
        ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
        c.add(0,a);
        c.add(1,b);
        for(int i=0;i<c.size();++i)
            g.add(new ArrayList<Integer>());
        for(int i=0;i<c.size();++i){
            for(int j=i+1;j<c.size();++j){
                if(shouldConnect(c.get(i), c.get(j))){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        return bfs(g,0,1);
    }

    public boolean shouldConnect(String a, String b){
        boolean flag=true;
        for(int i=0;i<a.length();++i){
            if(a.charAt(i)!=b.charAt(i)){
                if(flag)
                    flag=false;
                else
                    return false;
            }
        }
        return true;
    }

    public int bfs(ArrayList<ArrayList<Integer>> g, int src, int dst){
        boolean visited[]=new boolean[g.size()];
        int pathLength[]=new int[g.size()];
        Deque<Integer> q=new LinkedList<Integer>();
        q.add(src);
        visited[src]=true;
        pathLength[src]=1;
        while(q.size()!=0){
            int u=q.pollFirst();
            if(u==dst)
                return pathLength[u];
            for(int v:g.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    pathLength[v]=pathLength[u]+1;
                    q.add(v);
                }
            }
        }
        return 0;
    }

}
