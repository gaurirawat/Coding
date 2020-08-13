package IB;

import java.util.*;
//https://www.interviewbit.com/problems/commutable-islands/
public class Graph_ib_commutable_islands {
    public int solve(int a, ArrayList<ArrayList<Integer>> g) {
        int set[]=new int[a];
        for(int i=0;i<a;++i)
            set[i]=i;
        int sum=0;
        Collections.sort(g, Comparator.comparing(x->x.get(2)));
        for(int i=0;i<g.size();++i){
            ArrayList<Integer> l=g.get(i);
            if(!find(l.get(0)-1, l.get(1)-1, set)){
                sum+=l.get(2);
                union(l.get(0)-1, l.get(1)-1, set);
            }
        }
        return sum;
    }

    public boolean find(int x, int y, int[]set){
        if(set[x]==set[y])
            return true;
        return false;
    }

    public void union(int x, int y, int[]set){
        int sety=set[y];
        for(int i=0;i<set.length;++i){
            if(set[i]==sety)
                set[i]=set[x];
        }
    }
}

/*
public int solve(int a, ArrayList<ArrayList<Integer>> g) {
        boolean visited[]=new boolean[a];
        int cost[]=new int[a];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0]=0;
        int sum=0;
        for(int i=0;i<a;++i){
            int v= getMinDisNode(cost,visited);
            sum+=cost[v];
            visited[v]=true;
            updateDistance(v, cost, visited, g);
        }
       return sum;
    }

    public void updateDistance(int u,int cost[], boolean visited[], ArrayList<ArrayList<Integer>> g){
        for(ArrayList<Integer> l: g){
            int a=l.get(0)-1;
            int b=l.get(1)-1;
            int c=l.get(2);
            if(u==a && !visited[b] && cost[b]>c)
                cost[b]=c;
            if(u==b && !visited[a] && cost[a]>c)
                cost[a]=c;
        }
    }

    public int getMinDisNode(int cost[], boolean visited[]){
        int min=Integer.MAX_VALUE;
        int v=0;
        for(int i=0;i<cost.length;++i){
            if(!visited[i] && cost[i]<min){
                v=i;
                min=cost[i];
            }
        }
        return v;
    }
 */