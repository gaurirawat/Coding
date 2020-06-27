package revision;
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/?track=sp-graph&batchId=152

/* The only difference between looking for cycles in directed and undirected graph is checking
for parent nodes. In a directed graph every node will have an edge to its parent also. So in line 
no 30 we are checking if a node leads to cycle detection only if it is not a parent of the current 
node.*/

import java.util.*;
public class Graph_gfg_cycle_detection_undirected {
	
	static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       boolean visited[]= new boolean[V];
       boolean stack[]= new boolean[V];
       for(int i=0; i<V; ++i){
       		if(innerIsCyclic(-1,i,g, visited,stack))
       			return true;
       }
       return false;
    }

    
    static boolean innerIsCyclic(int parent,int x, ArrayList<ArrayList<Integer>> g, boolean visited[],boolean stack[]){
    	if(stack[x])
    		return true;
    	if(visited[x])
    		return false;
    	stack[x]= true;
    	visited[x]= true;
    	for(Integer i: g.get(x)){
    		if(i!=parent && innerIsCyclic(x,i, g, visited, stack)) 
    		    return true;
    	}   
    	stack[x]= false;
    	return false;
    }
}
