package IB;
//https://www.interviewbit.com/problems/water-flow/
public class Graph_ib_water_flow {
    public int solve(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        boolean[][] red= new boolean[m][n];
        boolean[][] blue= new boolean[m][n];
        for(int i=0;i<m;++i) {
            reverseWaterDfs(i, 0, a, red);
        }
        for(int j=0;j<n;++j) {
            reverseWaterDfs(0, j, a, red);
        }

        for(int i=0;i<m;++i) {
            reverseWaterDfs(i, n-1, a, blue);
        }
        for(int j=0;j<n;++j) {
            reverseWaterDfs(m-1, j, a, blue);
        }
        int c=0;
        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                if(red[i][j] && blue[i][j]){
                    c++;
                }
            }
        }
        return c;
    }

    public void reverseWaterDfs(int x, int y, int[][]a, boolean sea[][]) {
        sea[x][y]=true;
        for(int[] arr: new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
            int newi=x+arr[0];
            int newj=y+arr[1];
            if(newi>=0 && newj>=0 && newi<a.length && newj<a[0].length && a[x][y]<=a[newi][newj] && !sea[newi][newj]) {
                reverseWaterDfs(newi, newj, a, sea);
            }
        }
    }
}
