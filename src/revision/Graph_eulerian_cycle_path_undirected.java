package revision;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//refer graph notes
public class Graph_eulerian_cycle_path_undirected {
    public void isEulerian(ArrayList<ArrayList<Integer>> g) {
        //find first non connected vertex and perform dfs. no other component should be present
        boolean[] visited = new boolean[g.size()];
        boolean flag=true;
        int oddDegreeVertexCount=0;
        boolean notEuler=false;
        for(int i=0;i<g.size();++i) {
            if(!visited[i] && g.get(i).size()!=0){
                if(flag) {
                    dfs(i, visited,g);
                } else{
                    notEuler=true;
                }
            }

            if(g.get(i).size()%2!=0) {
                oddDegreeVertexCount++;
            }
        }

        if(notEuler || oddDegreeVertexCount>2) {
            System.out.println("Not euler");
        } else if(oddDegreeVertexCount==2) {
            System.out.println("Euler path");
        } else {
            System.out.println("Euler cycle");
        }
    }

    static void dfs(int i, boolean visited[], ArrayList<ArrayList<Integer>> g){
        visited[i]= true;
        Iterator<Integer> itr= g.get(i).listIterator();
        while(itr.hasNext()){
            i= itr.next();
            if(!visited[i]){
                dfs(i, visited,g);
            }
        }
    }
}
