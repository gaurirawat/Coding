package revision;
// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall/0/

/*
We initialize the solution matrix same as the input graph matrix as a first step. 
Then we update the solution matrix by considering all vertices as an intermediate vertex. 
The idea is to one by one pick all vertices and updates all shortest paths which include the 
picked vertex as an intermediate vertex in the shortest path. When we pick vertex number k as an 
intermediate vertex, we already have considered vertices {0, 1, 2, .. k-1} as intermediate 
vertices. For every pair (i, j) of the source and destination vertices respectively, there are
 two possible cases.
1) k is not an intermediate vertex in shortest path from i to j. We keep the value of g[i][j] as it is.
2) k is an intermediate vertex in shortest path from i to j. We update the value of g[i][j] 
as g[i][k] + g[k][j] if g[i][j] > g[i][k] + g[k][j]
*/

import java.util.*;
import java.io.*;
public class Graph_gfg_APSP_floyd_warshall {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t--!=0){
			int v= Integer.parseInt(br.readLine());
			int g[][]= new int[v][v];
			for(int i=0; i<v;++i){
				String arr[]= br.readLine().split(" ");
				for(int j=0; j<v; ++j)
					g[i][j]= arr[j].equals("INF")?Integer.MAX_VALUE:Integer.parseInt(arr[j]);
				}
			floydWarshall(v, g);
			for(int u_=0; u_<v; ++u_){
				for(int v_=0; v_< v;++v_){
					System.out.print(g[u_][v_]==Integer.MAX_VALUE?"INF":g[u_][v_]+ " ");
				}
				System.out.println();
			}
		}
	}

	public static void floydWarshall(int V, int[][] g){
		for(int i=0; i<V;++i){
			for(int u=0; u<V; ++u){
				for(int v=0; v< V;++v){//here 0 is for 0 wt, INF is for disconnected
					g[u][v]= Math.min(g[u][v], g[u][i]+g[i][v]);
				}
			}
		}
	}
}