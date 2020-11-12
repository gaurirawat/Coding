package IB;

import java.util.*;
//https://www.interviewbit.com/problems/min-cost-path/
//https://www.geeksforgeeks.org/0-1-bfs-shortest-path-binary-graph/

 // 0/1 BFS solution
public class Graph_ib_min_cost_path_0_1_BFS {
    public int solve(int m, int n, String[] s) {
        int cost[][]= new int[m][n];
        for(int i=0;i<m;++i)
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        Deque<Coordinate> q=new LinkedList<Coordinate>();
        q.add(new Coordinate(0,0));
        cost[0][0]=0;
        while(!q.isEmpty()){
            Coordinate cord=q.pollFirst();
            if(cord.i==cost.length-1 && cord.j==cost[0].length-1)
                return cost[cord.i][cord.j];

            char ch=s[cord.i].charAt(cord.j);
            int t;
            if(ch=='U') t=0;
            else if(ch=='D') t=1;
            else if(ch=='L') t=2;
            else t=3;

            int dx[]={-1,+1,0,0};
            int dy[]={0,0,-1,1};

            for(int i=0;i<4;++i){
                // System.out.println((i==t)+" "+i+" "+t);
                int ti=cord.i+dx[i];
                int tj=cord.j+dy[i];
                if(ti>=0 && tj>=0 && ti<cost.length && tj<cost[0].length &&
                        cost[ti][tj]>(cost[cord.i][cord.j]+(i==t?0:1))){
                    if(i==t){
                        q.addFirst(new Coordinate(ti,tj));
                        cost[ti][tj]=cost[cord.i][cord.j];
                        // System.out.println(ti+"follow"+tj+ " "+cost[ti][tj]);
                    }
                    else{
                        q.addLast(new Coordinate(ti,tj));
                        cost[ti][tj]=cost[cord.i][cord.j]+1;
                        // System.out.println(ti+"not follow"+tj+ " "+cost[ti][tj]);
                    }
                }
            }
        }
        return 0;
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

/*
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
 */