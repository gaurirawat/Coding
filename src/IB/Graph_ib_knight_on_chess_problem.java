package IB;

import java.util.*;
//https://www.interviewbit.com/problems/knight-on-chess-board/
public class Graph_ib_knight_on_chess_problem {
    int R, C;
    public int knight(int r, int c, int si, int sj, int di, int dj) {
        boolean visited[][]=new boolean[r][c];
        R=r;
        C=c;
        si--;sj--;
        di--;dj--;
        Deque<Three> q=new LinkedList<Three>();
        q.add(new Three(si,sj,0));
        while(q.size()!=0){
            Three curr=q.pollFirst();
            if(curr.i==di && curr.j==dj)
                return curr.moves;
            int DXY[][]={{2,-1},{2,1},{-2,-1},{-2,1},{-1,2},{1,2},{-1,-2},{1,-2}};
            for(int[] dxy: DXY){
                int ti=curr.i+dxy[0];
                int tj=curr.j+dxy[1];
                if(isValid(ti,tj) && !visited[ti][tj]){
                    visited[ti][tj]=true;
                    q.addLast(new Three(ti,tj,curr.moves+1));
                }
            }
        }
        return -1;
    }

    public boolean isValid(int i, int j){
        return i>=0 && i<R && j>=0 && j<C;
    }
}

class Three{
    int i, j, moves;
    public Three(int x, int y, int z){
        i=x;
        j=y;
        moves=z;
    }
}
