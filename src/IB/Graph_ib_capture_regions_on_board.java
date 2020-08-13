package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/capture-regions-on-board/
public class Graph_ib_capture_regions_on_board {
    public void solve(ArrayList<ArrayList<Character>> a) {
        boolean visited[][]=new boolean[a.size()][a.get(0).size()];
        int i,j;

        i=0;
        for(j=0;j<a.get(0).size();++j)
            if(a.get(i).get(j)=='O')
                dfs(i,j,visited,a);

        j=0;
        for(i=0;i<a.size();++i)
            if(a.get(i).get(j)=='O')
                dfs(i,j,visited,a);

        i=a.size()-1;
        for(j=0;j<a.get(0).size();++j)
            if(a.get(i).get(j)=='O')
                dfs(i,j,visited,a);

        j=a.get(0).size()-1;
        for(i=0;i<a.size();++i)
            if(a.get(i).get(j)=='O')
                dfs(i,j,visited,a);

        for(i=0;i<a.size();++i)
            for(j=0;j<a.get(0).size();++j)
                if(!visited[i][j] && a.get(i).get(j)=='O')
                    a.get(i).set(j,'X');
    }

    public void dfs(int i, int j, boolean[][]visited, ArrayList<ArrayList<Character>> a){
        if(i<0||j<0||i>=a.size()||j>=a.get(0).size()||visited[i][j]||a.get(i).get(j)=='X')
            return;
        visited[i][j]=true;
        dfs(i+1,j,visited,a);
        dfs(i-1,j,visited,a);
        dfs(i,j+1,visited,a);
        dfs(i,j-1,visited,a);
    }
}
