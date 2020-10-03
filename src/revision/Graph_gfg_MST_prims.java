package revision;
// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
/*
Algorithm
1) Create a set mstSet that keeps track of vertices already included in MST.
2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the first vertex so that it is picked first.
3) While mstSet doesn't include all vertices
�.a) Pick a vertex u which is not there in mstSet and has minimum key value.
�.b) Include u to mstSet.
�.c) Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices. For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v

Here the priority contains the edge weights and not their sum(like the way it happens in dijkstra)
*/

import java.util.*;
public class Graph_gfg_MST_prims {

	 static int spanningTree(int v, int e, ArrayList<ArrayList<Integer>> g) {
        int parent[]= new int[v];
        boolean isSet[]= new boolean[v];
        int priority[]= new int[v]; //contains minimum weights to reach the currently reachable vertes
        Arrays.fill(priority, Integer.MAX_VALUE);

     	priority[0]=0;
     	parent[0]=-1;
     	int sum=0;

		 /*iterate through all vertices. Out of the vertices that are not set select the one with
		  *the minimum priority. Set it and update the priority of other vertices reachable from current
		  *vertex. If any changes are made then update parent[] also.
		  */
        for(int i=0;i<v;++i){
        	int x=getMinEdge(priority,isSet);
        	isSet[x]= true;
        	sum+= (parent[x]==-1?0: g.get(x).get(parent[x]));//do not add sum for the first vertex since its parent is -1
        	updatePriority(x, priority,parent, isSet, g.get(x));
        }
        return sum;
    }

   public static void updatePriority(int x, int priority[],int parent[], boolean isSet[], ArrayList<Integer> g){	
    	for(int i=0; i<priority.length; ++i ){//loop is running v times since underlying DS is adjacency matrix
    		if(!isSet[i] && g.get(i)!=0 && priority[i]>g.get(i)){
    			priority[i]=g.get(i);
    			parent[i]=x;
    		}
    	}
    }

    public static int getMinEdge(int priority[], boolean isSet[]){
    	int v=Integer.MAX_VALUE;
    	int val=Integer.MAX_VALUE;
    	for(int i=0; i< priority.length;++i){
    		if(!isSet[i] && priority[i]< val){
    			v=i;
    			val= priority[i];
    		}
    	}
    	return v;
    }
}
/*
Min Heap implementation:

	static int spanningTree(int n, int E, ArrayList<ArrayList<Integer>> g) {
        int sum=0;
        int dist[]=new int[n];
        boolean visited[]=new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Edge> minH=new PriorityQueue<Edge>(Comparator.comparingInt(a->a.cost));
        minH.add(new Edge(0,0));
        dist[0]=0;
        visited[0]=true;
        while(!minH.isEmpty()){
            Edge e=minH.poll();
            visited[e.v]=true;
            sum+=e.cost;
            int u=e.v;
            for(int v=0;v<n;++v){
                if(!visited[v] && dist[v]>g.get(u).get(v)){
                    minH.remove(new Edge(v,dist[v]));
                    minH.add(new Edge(v,g.get(u).get(v)));
                    dist[v]=g.get(u).get(v);
                }
            }
        }

        return sum;
    }

	class Edge{
		int v;
		int cost;
		public Edge(int v, int cost){
			this.v=v;
			this.cost=cost;
		}
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Edge)) return false;
			Edge edge = (Edge) o;
			return v == edge.v &&
					cost == edge.cost;
		}
	}
 */