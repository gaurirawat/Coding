package revision;
//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

import java.util.*;

public class Graph_gfg_count_no_of_islands {
    static int findIslands(ArrayList<ArrayList<Integer>> g, int r, int c) {
        int cnt=0;
        boolean visited[][]=new boolean[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(!visited[i][j] && g.get(i).get(j)==1 && findIslandsBFS(g,new Coordinate(i,j,0), visited)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean findIslandsBFS(ArrayList<ArrayList<Integer>> g, Coordinate src, boolean[][]visited){
        if(g.get(src.i).get(src.j)==0) return false;
        int r=g.size();
        int c=g.get(0).size();
        Deque<Coordinate> q= new LinkedList<Coordinate>();
        q.addLast(new Coordinate(src.i,src.j,0));
        int destPath=-1;
        while(q.size()!=0){
            Coordinate curr=q.pollFirst();
            int i=curr.i;
            int j=curr.j;
            visited[i][j]=true;
            if(i<r-1 && !visited[i+1][j] && g.get(i+1).get(j)==1){
                q.add(new Coordinate(i+1,j,curr.path+1));
                visited[i+1][j]=true;
            }
            if(j<c-1 && !visited[i][j+1] && g.get(i).get(j+1)==1){
                q.add(new Coordinate(i,j+1,curr.path+1));
                visited[i][j+1]=true;
            }

            if(i>0 && !visited[i-1][j] && g.get(i-1).get(j)==1){
                q.add(new Coordinate(i-1,j,curr.path+1));
                visited[i-1][j]=true;
            }
            if(j>0 && !visited[i][j-1] && g.get(i).get(j-1)==1) {
                q.add(new Coordinate(i, j - 1, curr.path + 1));
                visited[i][j-1] = true;
            }

            if(i<r-1 && j<c-1&& !visited[i+1][j+1] && g.get(i+1).get(j+1)==1){
                q.add(new Coordinate(i+1,j+1,0));
                visited[i+1][j+1]=true;
            }
            if(i>0 && j>0&& !visited[i-1][j-1] && g.get(i-1).get(j-1)==1){
                q.add(new Coordinate(i-1,j-1,0));
                visited[i-1][j-1]=true;
            }


            if(i>0 && j<c-1 && !visited[i-1][j+1] && g.get(i-1).get(j+1)==1){
                q.add(new Coordinate(i-1,j+1,0));
                visited[i-1][j+1]=true;
            }

            if(i<r-1 && j>0 && !visited[i+1][j-1] && g.get(i+1).get(j-1)==1){
                q.add(new Coordinate(i+1,j-1,0));
                visited[i+1][j-1]=true;
            }
        }
        return true;
    }
}
