package IB;

import java.util.*;
//https://www.interviewbit.com/problems/min-cost-path/

// GO THROUGH EDITORIAL SOLUTION
public class Graph_ib_min_cost_path {
    public int solve(int m, int n, String[] s) {
        int cost[][]=new int[m][n];
        for(int i=0;i<m;++i)
            Arrays.fill(cost[i], -1);
        Deque<Coordinate> q= new LinkedList<Coordinate>();
        cost[0][0]=0;
        q.add(new Coordinate(0,0));
        while(true){
            int x=followDirections(q,cost,s);
            if(x!=-1)return x;
            x=dontFollowDirections(q,cost,s);
            if(x!=-1)return x;
        }
    }

    public int followDirections(Deque<Coordinate> q, int cost[][], String[] s){
        Deque<Coordinate> t= new LinkedList<Coordinate>();
        while(!q.isEmpty()){
            Coordinate cord=q.poll();
            if(cord.i==cost.length-1 && cord.j==cost[0].length-1)
                return cost[cord.i][cord.j];
            t.add(cord);
            char ch=s[cord.i].charAt(cord.j);
            int ti=cord.i,tj=cord.j;
            if(ch=='U') ti--;
            else if(ch=='D') ti++;
            else if(ch=='L') tj--;
            else tj++;
            if(ti>=0 && tj>=0 && ti<cost.length && tj<cost[0].length && cost[ti][tj]==-1){
                // System.out.println(ti+"follow"+tj);
                q.add(new Coordinate(ti,tj));
                cost[ti][tj]=cost[cord.i][cord.j];
            }
        }
        q.addAll(t);
        return -1;
    }

    public int dontFollowDirections(Deque<Coordinate> q, int cost[][], String[] s){
        Deque<Coordinate> t= new LinkedList<Coordinate>();
        while(!q.isEmpty()){
            Coordinate cord=q.poll();
            int dx[]={0,0,1,-1};
            int dy[]={1,-1,0,0};
            for(int i=0;i<4;++i){
                int ti=cord.i+dx[i];
                int tj=cord.j+dy[i];
                if(ti>=0 && tj>=0 && ti<cost.length && tj<cost[0].length && cost[ti][tj]==-1){
                    // System.out.println(ti+"not follow"+tj);
                    t.add(new Coordinate(ti,tj));
                    cost[ti][tj]=cost[cord.i][cord.j]+1;
                    if(ti==cost.length-1 && tj==cost[0].length-1)
                        return cost[ti][tj];
                }
            }
        }
        q.addAll(t);
        return -1;
    }
    class Coordinate{
        int i;
        int j;
        public Coordinate(int a, int b){
            i=a;
            j=b;
        }
    }
}