package revision;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/minimum-cost-path/0

public class Graph_gfg_find_min_path_up_down_left_right_movement {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int l= Integer.parseInt(sc.nextLine());
            int arr[][]= new int[l][l];
            String x[]=sc.nextLine().split(" ");
            int c=0;
            for(int i=0;i<l;++i){
                for(int j=0;j<l;++j)
                    arr[i][j]=Integer.parseInt(x[c++]);
            }
            System.out.println(dijkstra2D(arr,l));
        }
    }

    public static int dijkstra2D(int arr[][], int l){
        int distance[][]= new int[l][l];
        for(int i=0;i<l;++i)
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        PriorityQueue<Coordinate> heap= new PriorityQueue<Coordinate>(
                Comparator.comparingInt(a->a.path));
        heap.add(new Coordinate(0,0,arr[0][0]));
        boolean[][]visited= new boolean[l][l];
        visited[0][0]=true;
        while(heap.size()!=0){
            Coordinate curr=heap.poll();
            if(curr.i==l-1 && curr.j==l-1)
                return curr.path;
            int dx[]={0,0,1,-1};
            int dy[]={1,-1,0,0};
            for(int x=0;x<4;++x){
                int newi=curr.i+dx[x];
                int newj=curr.j+dy[x];
                if(newi>=0 && newi<l && newj>=0 && newj<l && !visited[newi][newj]){
                    visited[newi][newj]=true;
                    heap.add(new Coordinate(newi, newj, curr.path+arr[newi][newj]));
                }
            }
        }
        return -1;
    }
}
