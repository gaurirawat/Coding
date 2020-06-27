package revision;
// https://practice.geeksforgeeks.org/problems/negative-weight-cycle/0#ExpectOP

/*
Input: Graph and a source vertex src Output: Shortest distance to all vertices from src. If there is a negative weight cycle, then shortest distances are not calculated, negative weight cycle is reported.

1) This step initializes distances from the source to all vertices as infinite and distance to the source itself as 0. Create an array dist[] of size |V| with all values as infinite except dist[src] where src is source vertex.
2) This step calculates shortest distances. Do following |V|-1 times where |V| is the number of vertices in given graph.
.....a) Do following for each edge u-v
..................If dist[v] > dist[u] + weight of edge uv, then update dist[v]
......................dist[v] = dist[u] + weight of edge uv
3) This step reports if there is a negative weight cycle in graph. Do following for each edge u-v
......If dist[v] > dist[u] + weight of edge uv, then "Graph contains negative weight cycle"
The idea of step 3 is, step 2 guarantees the shortest distances if the graph doesn't contain a negative weight cycle. If we iterate through all edges one more time and get a shorter path for any vertex, then there is a negative weight cycle

*/

import java.util.*;
import java.io.*;
public class Graph_gfg_SP_bellman_ford_cycle_detection {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t--!=0){
			String arr[]= br.readLine().split(" ");
			int v= Integer.parseInt(arr[0]);
			int e= Integer.parseInt(arr[1]);
			if(e==0|| v==0){
			    System.out.println(0);
			    continue;
			}
			    
			arr= br.readLine().split(" ");
			ArrayList<Edge> edges= new ArrayList<Edge>();
			int k=0;
			for(int i=0; i<e;++i) {
				Edge ed=new Edge(Integer.parseInt(arr[k]),Integer.parseInt(arr[k+1]), Integer.parseInt(arr[k+2])); 
				edges.add(ed);
				k+=3;
				// System.out.println(ed.u+" "+ ed.v+" "+ ed.w);
			}
			System.out.println(bellmanFord(v, edges));
		}
	}


	public static int bellmanFord(int v, ArrayList<Edge> edges){
		int distance[]= new int[v+1];
		/*we are doing v+1 because even when the question says so, the input for v is not v:1->v, it actually 
		actually given as v: 0-> v-1;
		*/ 
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0]=0;
		for(int i=0; i<v-1;++i){
			for(Edge e:edges){
			 //   System.out.println(e.u+" "+ e.v+" "+ e.w );
				if(distance[e.u]!=Integer.MAX_VALUE && distance[e.v]>distance[e.u]+e.w)
					distance[e.v]= distance[e.u]==Integer.MAX_VALUE?0:distance[e.u]+e.w;
			}
		}
        // System.out.println(distance.toString());
		for(Edge e:edges){
			if(distance[e.u]!=Integer.MAX_VALUE && distance[e.v]>distance[e.u]+e.w)
				return 1;// negative cycle is detected
		}
		return 0;
	}
}

class Edge{
	int u;
	int v;
	int w;
	public Edge(int u, int v, int w){
		this.u=u;
		this.v=v;
		this.w=w;
	}
	public Edge(){}
}
