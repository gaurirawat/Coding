package revision;
// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1/?track=sp-graph&batchId=152
//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

/* this is similar to prims except that we keep minimum distances inside the priority array here while
in prims we store the minimum edge. Also here we n=do not need the parent array since we do not need 
to keep track of any path. Also before updating the distance we check if it is !=0(ie node is connected or not)
*/

/*While calculating MST or SP remember to put checks for !=0 when using adacency matrix otherwise 
/disconnented graphs will cause incorrect answers
*/
import java.util.*;
public class Graph_gfg_SP_dijkstra_adjacency_matrix {

	static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        boolean isSet[]= new boolean[V];
        int priority[]= new int[V]; //contains minimum distance from src to the currently reachable vertes
        Arrays.fill(priority, Integer.MAX_VALUE);

     	priority[src]=0;

        for(int i=0;i<V;++i){
        	int u=getMinEdge(priority,isSet);
        	isSet[u]= true;
        	updatePriority(u,priority, isSet, g.get(u));
        }
        return priority;
    }

     public static void updatePriority(int u,int priority[], boolean isSet[], ArrayList<Integer> g){	
    	for(int v=0; v<priority.length; ++v ){
    		if(!isSet[v] && g.get(v)!=0 && priority[v]>priority[u]+g.get(v))
    			priority[v]=priority[u]+g.get(v);
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
