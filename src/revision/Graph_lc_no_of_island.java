package revision;
//https://leetcode.com/problems/number-of-islands/submissions/
public class Graph_lc_no_of_island {
    public int numIslands(char[][] g) {
        boolean visited[][]=new boolean[g.length][g[0].length];
        int c=0;
        for(int i=0; i<g.length;++i) {
            for(int j=0; j<g[0].length;++j) {
                if(!visited[i][j] && g[i][j]=='1') {
                    dfs(i,j,g,visited);
                    c++;
                }
            }
        }
        return c;
    }

    public void dfs(int i, int j, char[][] g, boolean[][] visited) {
        visited[i][j]=true;
        int[][] dxy=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int p=0; p<4; ++p) {
            int newi=i+dxy[p][0];
            int newj=j+dxy[p][1];
            if(newi>=0 && newj>=0 && newi<g.length && newj<g[0].length && !visited[newi][newj] && g[newi][newj]=='1') {
                dfs(newi, newj, g, visited);
            }
        }
    }
}
