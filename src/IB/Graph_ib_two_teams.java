package IB;

import java.util.*;

//https://www.interviewbit.com/problems/two-teams/
public class Graph_ib_two_teams {
    public int solve(int n, int[][] b) {
        ArrayList<ArrayList<Integer>> g= new ArrayList<ArrayList<Integer>> ();
        for(int i=0;i<n;++i){
            g.add(new ArrayList<Integer>());
        }
        for(int i=0;i<b.length;++i) {
            int x=b[i][0]-1;
            int y=b[i][1]-1;
            g.get(x).add(y);
            g.get(y).add(x);
        }
        int[] level=new int[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;++i) {
            if(!visited[i] && !isPossible(i,level,visited,g)){
                return 0;
            }
        }
        return 1;
    }

    public boolean isPossible(int i, int[] level, boolean[] visited, ArrayList<ArrayList<Integer>> g){
        visited[i]=true;
        level[i]=1;
        Deque<Integer> q= new LinkedList<Integer>();
        q.add(i);
        while(!q.isEmpty()){
            int curr=q.pollFirst();
            for(int x: g.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    level[x]=-level[curr];
                    q.addLast(x);
                }
                else if(level[curr]==level[x]){
                    return false;
                }
            }
        }
        return true;
    }
}
