package revision;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/?track=sp-graph&batchId=152
public class Graph_gfg_bfs {

	static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
		boolean visited[] = new boolean[N];
        ArrayList<Integer> res= new ArrayList<Integer>();
        for(int i=0; i<N;++i){
            if(!visited[i])
                 innerBfs(i, g, visited, res);
        }
        return res;
    }

	static void innerBfs(int x, ArrayList<ArrayList<Integer>> g, boolean visited[], ArrayList<Integer> res ) {        
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(x);
        while(!q.isEmpty()){
        	x= q.remove();
        	res.add(x);
        	Collections.sort(g.get(x));
			Iterator<Integer> itr= g.get(x).listIterator();		
			while(itr.hasNext()){
				x= itr.next();
				if(!visited[x]){
				    visited[x]= true;// remember visited has to be updated here.
					q.add(x);
				}
	        }
	    }
    }
}
