package IB;

import java.util.*;
//https://www.interviewbit.com/problems/valid-path/
public class Graph_ib_valid_path {
    public String solve(int r, int c, int noc, int rad, int[] xoc, int[] yoc) {
        if(r==0 && c==0)return "YES";
        boolean isValid[][]=new boolean[r+1][c+1];
        calculateValidity(rad, xoc, yoc,isValid);
        if(!isValid[0][0] && !isValid[r][c]) return "NO";

        Coordinate o= new Coordinate(0,0);
        Deque<Coordinate> q=new LinkedList<Coordinate>();
        q.addLast(o);
        boolean visited[][]=new boolean[r+1][c+1];
        int dx[]={0,1,1,0,-1,-1,-1,1};
        int dy[]={1,0,1,-1,0,-1,1,-1};

        visited[0][0]=true;
        while(q.size()!=0){
            Coordinate cord=q.pollFirst();
            if(cord.x==r && cord.y==c) return "YES";
            for(int i=0;i<dx.length;++i){
                int tx=cord.x+dx[i];
                int ty=cord.y+dy[i];
                if(tx>=0 && ty>=0 && tx<=r && ty<=c && isValid[tx][ty] && !visited[tx][ty]){
                    visited[tx][ty]=true;
                    q.addLast(new Coordinate(tx,ty));
                }
            }
        }
        return "NO";
    }

    public void calculateValidity(int rad,int xoc[], int yoc[], boolean isValid[][]){
        for(int i=0;i<isValid.length;++i){
            for(int j=0;j<isValid[0].length;++j){
                isValid[i][j]=true;
                for(int k=0;k<xoc.length;++k){
                    if(Math.sqrt( Math.pow(i-xoc[k],2)+Math.pow(j-yoc[k],2))<=rad){
                        isValid[i][j]=false;
                        break;
                    }
                }
            }
        }
    }
    class Coordinate{
        int x; int y;
        public Coordinate(int a, int b){
            x=a;
            y=b;
        }
    }
}

