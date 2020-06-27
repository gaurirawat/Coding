package revision;
// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/?track=sp-graph&batchId=152

/*We are doing sort here so that we visit the nodes-> smallest first.
*/

import java.util.*;
public class Graph_gfg_dfs {

	static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       boolean visited[] = new boolean[N];
       ArrayList<Integer> res= new ArrayList<Integer>();
       for(int i=0; i<N;++i){
           if(!visited[i])
                innerDfs(i, g, visited, res);
       }
       return res;
    }

   static void innerDfs(int i, ArrayList<ArrayList<Integer>> g, boolean visited[], ArrayList<Integer> res){
    	visited[i]= true;
    	res.add(i);
    	Collections.sort(g.get(i));
  		Iterator<Integer> itr= g.get(i).listIterator();		
  		while(itr.hasNext()){
  			i= itr.next();
  			if(!visited[i]){
  			 //   System.out.println("add"+ i);
  				innerDfs(i, g, visited, res);
  			}
  		}
	}
}
