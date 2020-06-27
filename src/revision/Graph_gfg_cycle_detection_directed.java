 package revision;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/?track=sp-graph&batchId=152

/*before calling the innerCyclic from within the innerCyclic do not put a check of if(visited[i]) because then the program will 
simply not check for any vertex that is already visited and will always return false for every graph.
*/

public class Graph_gfg_cycle_detection_directed {

	static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       boolean visited[]= new boolean[V];
       boolean stack[]= new boolean[V];
       for(int i=0; i<V; ++i){
       		if(innerIsCyclic(i,g, visited,stack))
       			return true;
       }
       return false;
    }

    
    static boolean innerIsCyclic(int x, ArrayList<ArrayList<Integer>> g, boolean visited[],boolean stack[]){
    	if(stack[x])
    		return true;
    	if(visited[x])
    		return false;
    	stack[x]= true;
    	visited[x]= true;
    	for(Integer i: g.get(x)){
    		if(innerIsCyclic(i, g, visited, stack)) 
    		    return true;
    	}   
    	stack[x]= false;
    	return false;
    }
}

