package IB;

import java.util.*;

public class Graph_ib_word_ladder_2 {
    ArrayList<ArrayList<String>> ans;
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        HashSet<String> set=new HashSet<String>();
        set.addAll(dict);
        dict.clear();
        dict.addAll(set);
        set.clear();
        if(dict.contains(start)) dict.remove(start);
        if(dict.contains(end)) dict.remove(end);
        dict.add(0,start);
        dict.add(1,end);
        ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
        ans =new ArrayList<ArrayList<String>>();
        for(int i=0;i<dict.size();++i)
            g.add(new ArrayList<Integer>());
        for(int i=0;i<dict.size();++i){
            for(int j=i+1;j<dict.size();++j){
                if(canConnect(dict.get(i), dict.get(j))){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        // System.out.println(g.toString());
        // System.out.println(dict.toString());
        int minMoves=calcMinMoves(0,1,g);
        if(minMoves==-1) return ans;
        if(start.equals(end)){
            ArrayList<String> l=new ArrayList<String>();
            l.add(start);
            ans.add(l);
            return ans;
        }
        boolean visited[]=new boolean[dict.size()];
        visited[0]=true;
        dfs(minMoves,0,-1,visited,g,new ArrayList<String>(),dict);
        return ans;
    }

    public int calcMinMoves(int src, int dest, ArrayList<ArrayList<Integer>> g){
        Deque<Pair> q=new LinkedList<Pair>();
        boolean visited[]=new boolean[g.size()];
        q.add(new Pair(src,0));
        visited[src]=true;
        while(q.size()!=0){
            Pair p=q.pollFirst();
            if(p.i==dest)
                return p.level;
            for(int v:g.get(p.i))
                if(!visited[v]){
                    visited[v]=true;
                    q.addLast(new Pair(v, p.level+1));
                }
        }
        return -1;
    }
    public void dfs(int n,int u, int parent, boolean visited[],ArrayList<ArrayList<Integer>> g, ArrayList<String> l,ArrayList<String> dict){
        if(n==0){
            if(u==1){
                ArrayList<String> t=new ArrayList<String>();
                t.addAll(l);
                t.add(dict.get(u));
                ans.add(t);
            }
            return;
        }
        visited[u]=true;
        l.add(dict.get(u));
        for(int v: g.get(u)){
            if(v!=parent && !visited[v])
                dfs(n-1,v,u,visited,g,l,dict);
        }
        l.remove(dict.get(u));
        visited[u]=false;
    }

    public boolean canConnect(String a, String b){
        boolean flag=true;
        for(int i=0;i<a.length();++i){
            if(a.charAt(i)!=b.charAt(i)){
                if(flag)
                    flag=!flag;
                else
                    return false;
            }
        }
        return true;
    }
}

class Pair{
    int i;
    int level;
    public Pair(int i, int level){
        this.i=i;
        this.level=level;
    }
}