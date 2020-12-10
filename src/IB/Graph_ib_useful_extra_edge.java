package IB;

import java.util.Arrays;
//https://www.interviewbit.com/problems/useful-extra-edges/
public class Graph_ib_useful_extra_edge {
    public int solve(int n, int[][] e, int src, int dst, int[][] extra) {
        src--;
        dst--;
        int[] dFromSrc=dijkstra(n, e, src);
        int[] dFromDst=dijkstra(n, e, dst);

        // System.out.println(Arrays.toString(dFromSrc));
        // System.out.println(Arrays.toString(dFromDst));

        long min=0L+dFromSrc[dst];
        for(int i=0;i<extra.length;++i) {
            int u=extra[i][0]-1;
            int v=extra[i][1]-1;
            if(u>=0 && v>=0 && u<n && v<n){
                long newDistance=0L+dFromSrc[u]+dFromDst[v]+extra[i][2];
                if(min>newDistance){
                    min=newDistance;
                }

                newDistance=0L+dFromSrc[v]+dFromDst[u]+extra[i][2];
                if(min>newDistance){
                    min=newDistance;
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:((int)min);
    }

    public int[] dijkstra(int n, int[][] e, int src) {
        boolean[] set=new boolean[n];
        int[] distance=new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;
        for(int i=0;i<n;++i) {
            int u=getMinReachableVertex(n, set, distance);
            set[u]=true;
            updateDistance(u, n, set, distance, e);
        }
        return distance;
    }

    public int getMinReachableVertex(int n, boolean[] set, int[] distance) {
        int minVertex=0;
        int minDistance=Integer.MAX_VALUE;
        for(int i=0;i<n;++i) {
            if(!set[i] && distance[i]<minDistance){
                minDistance=distance[i];
                minVertex=i;
            }
        }
        return minVertex;
    }

    public void updateDistance(int vertex, int n, boolean[] set, int[] distance, int[][]e){
        for(int i=0;i<e.length;++i){
            int u=e[i][0]-1;
            int v=e[i][1]-1;
            if(vertex==u && !set[v] && distance[u]!=Integer.MAX_VALUE && distance[v]>distance[u]+e[i][2]){
                distance[v]=distance[u]+e[i][2];
            }
            if(vertex==v && !set[u] && distance[v]!=Integer.MAX_VALUE && distance[u]>distance[v]+e[i][2]){
                distance[u]=distance[v]+e[i][2];
            }
        }
    }
}
