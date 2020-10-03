package IB;
//https://www.interviewbit.com/problems/maximum-sum-square-submatrix/
public class Array_ib_maximum_sum_square_submatrix {
    public int solve(int[][] a, int k) {
        int p[][]=new int[a.length][a.length-k+1];
        // int q[][]=new int[a.length-k+1][a.length-k+1];
        for(int i=0;i<a.length;++i){
            int sum=0;
            for(int j=0;j<k;++j)
                sum+=a[i][j];
            p[i][0]=sum;
            for(int j=0;j<p[0].length-1;++j){
                sum+=a[i][j+k]-a[i][j];
                p[i][j+1]=sum;
            }
        }

        int max=Integer.MIN_VALUE;
        for(int j=0;j<p[0].length;++j){
            int sum=0;
            for(int i=0;i<k;++i)
                sum+=p[i][j];
            max=Math.max(max,sum);
            for(int i=0;i<p[0].length-1;++i){
                sum+=p[i+k][j]-p[i][j];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}
