package revision;

import java.util.*;

public class Graph_gfg_shortest_path_in_a_maze {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String s[]=sc.nextLine().split(" ");
            int arr[][]= new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
            String x[]=sc.nextLine().split(" ");
            int c=0;
            for(int i=0;i<arr.length;++i){
                for(int j=0;j<arr[0].length;++j)
                    arr[i][j]=Integer.parseInt(x[c++]);
            }
            String y[]= sc.nextLine().split(" ");
            Coordinate dest= new Coordinate(Integer.parseInt(y[0]),Integer.parseInt(y[1]),0);
            System.out.println(leeAlgorithmBFS(arr,dest));
        }
    }

    public static int leeAlgorithmBFS(int[][]arr, Coordinate dest){
        if(arr[0][0]==0) return -1;
        int r=arr.length;
        int c=arr[0].length;
        boolean visited[][]=new boolean[r][c];
        visited[0][0]=true;
        Deque<Coordinate> q= new LinkedList<Coordinate>();
        q.addLast(new Coordinate(0,0,0));
        int destPath=-1;
        while(q.size()!=0){
            Coordinate curr=q.pollFirst();
            int i=curr.i;
            int j=curr.j;
            if(i==dest.i && j==dest.j){
                destPath=curr.path;
                break;
            }
            if(i<r-1 && !visited[i+1][j] && arr[i+1][j]==1){
                q.add(new Coordinate(i+1,j,curr.path+1));
                visited[i+1][j]=true;
            }
            if(j<c-1 && !visited[i][j+1] && arr[i][j+1]==1){
                q.add(new Coordinate(i,j+1,curr.path+1));
                visited[i][j+1]=true;
            }
            if(i>0 && !visited[i-1][j] && arr[i-1][j]==1){
                q.add(new Coordinate(i-1,j,curr.path+1));
                visited[i-1][j]=true;
            }
            if(j>0 && !visited[i][j-1] && arr[i][j-1]==1) {
                q.add(new Coordinate(i, j - 1, curr.path + 1));
                visited[i][j-1] = true;
            }
        }
        return destPath;
    }
}

class Coordinate{
    int i;
    int j;
    int path;
    public Coordinate(int x, int y, int path){
        this.i=x;
        this.j=y;
        this.path=path;
    }
}