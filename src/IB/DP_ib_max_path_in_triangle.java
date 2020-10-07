package IB;
//https://www.interviewbit.com/problems/maximum-path-in-triangle
public class DP_ib_max_path_in_triangle {
    public int solve(int[][] a) {
        for(int i=1;i<a.length;++i){
            for(int j=0;j<=i;++j)
                a[i][j]+=Math.max(a[i-1][j],j==0?0:a[i-1][j-1]);
        }
        int max=Integer.MIN_VALUE;
        for(int j=0;j<a[0].length;++j)
            max=Math.max(max,a[a.length-1][j]);
        return max;
    }
}