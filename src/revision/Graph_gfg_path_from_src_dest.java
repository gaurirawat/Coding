package revision;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0
public class Graph_gfg_path_from_src_dest {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int l=Integer.parseInt(sc.nextLine());
            int arr[][]= new int[l][l];
            String s[]=sc.nextLine().split(" ");
            int c=0;
            for(int i=0;i<l;++i){
                for(int j=0;j<l;++j){
                    arr[i][j]=Integer.parseInt(s[c++]);
                }
            }
            System.out.println(doesPathExist(arr)==true?1:0);
        }
    }

    public static boolean doesPathExist(int arr[][]){
        int l=arr.length;
        boolean visited[][]=new boolean[l][l];
        int i=0, j=0;
        outer:for(i=0;i<l;++i){
            for(j=0;j<l;++j)
                if(arr[i][j]==1) {
                    visited[i][j]=true;
                    break outer;
                }
        }
        Deque<Coordinate> q= new LinkedList<Coordinate>();
        q.addLast(new Coordinate(i,j,0));
        while(q.size()!=0){
            Coordinate curr=q.pollFirst();
            if(arr[curr.i][curr.j]==2)
                return true;
            int dx[]={0,1,0,-1};
            int dy[]={1,0,-1,0};
            for(i=0;i<4;++i){
                int x=curr.i+dx[i];
                int y=curr.j+dy[i];
                if(x<l && x>=0 && y<l && y>=0 && !visited[x][y] && arr[x][y]!=0){
                    visited[x][y]=true;
                    q.add(new Coordinate(x,y,0));
                }
            }
        }
        return false;
    }
}
