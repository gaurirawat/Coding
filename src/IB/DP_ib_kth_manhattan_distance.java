package IB;
//https://www.interviewbit.com/problems/kth-manhattan-distance-neighbourhood/
//https://www.youtube.com/watch?v=O0xdijU9l-g&ab_channel=Think%26Code
public class DP_ib_kth_manhattan_distance {
    public int[][] solve(int k, int[][] a) {
        for(int c=0;c<k;++c){
            int[][]t=new int[a.length][a[0].length];
            for(int i=0;i<a.length;++i){
                for(int j=0;j<a[0].length;++j){
                    t[i][j]=a[i][j];
                    int dx[]={0,0,1,-1};
                    int dy[]={-1,1,0,0};
                    for(int l=0;l<4;++l){
                        int x=i+dx[l];
                        int y=j+dy[l];
                        if(x>=0&&y>=0&&x<a.length&&y<a[0].length){
                            t[i][j]=Math.max(t[i][j],a[x][y]);
                        }
                    }
                }
            }
            a=t;
        }
        return a;
    }
}
