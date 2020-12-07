package revision;
//https://leetcode.com/problems/bricks-falling-when-hit/submissions/
public class Graph_lc_bricks_falling_when_hit {
    int[][] dxy;
    public int[] hitBricks(int[][] g, int[][] h) {
        dxy=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int arr[]=new int[h.length];
        for(int i=0;i<h.length;++i) {
            if(g[h[i][0]][h[i][1]]==0) {
                continue;
            }
            g[h[i][0]][h[i][1]]=0;
            for(int j=0;j<4;++j) {
                int newi= h[i][0]+dxy[j][0];
                int newj= h[i][1]+dxy[j][1];
                boolean[][] visited=new boolean[g.length][g[0].length];
                if(newi>=0 && newj>=0 && newi<g.length && newj<g[0].length && g[newi][newj]==1 && !isStableDfs(newi, newj, g, visited)) {
                    arr[i]+=removeAndGetCountDfs(newi, newj, g);
                }
            }
        }
        return arr;
    }

    public boolean isStableDfs(int i, int j, int[][]g, boolean[][]visited) {
        if(i==0) {
            return true;
        }
        for(int k=0;k<4;++k) {
            int newi= i+dxy[k][0];
            int newj= j+dxy[k][1];
            if(newi>=0 && newj>=0 && newi<g.length && newj<g[0].length && g[newi][newj]==1 && !visited[newi][newj]){
                visited[newi][newj]=true;
                if(isStableDfs(newi, newj, g, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public int removeAndGetCountDfs(int i, int j, int[][]g) {
        g[i][j]=0;
        int c=1;
        for(int k=0;k<4;++k) {
            int newi= i+dxy[k][0];
            int newj= j+dxy[k][1];
            if(newi>=0 && newj>=0 && newi<g.length && newj<g[0].length && g[newi][newj]==1){
                c+=removeAndGetCountDfs(newi, newj, g);
            }
        }
        return c;
    }
}
