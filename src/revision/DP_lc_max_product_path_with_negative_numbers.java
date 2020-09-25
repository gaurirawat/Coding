package revision;
//https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/submissions/
public class DP_lc_max_product_path_with_negative_numbers {
    public int maxProductPath(int[][] g) {
        long p[][]=new long[g.length+1][g[0].length+1];
        long n[][]=new long[g.length+1][g[0].length+1];

        for(int i=1;i<=g.length;++i){
            for(int j=1;j<=g[0].length;++j){
                long num=g[i-1][j-1];
                if(i==1&&j==1){
                    p[i][j]=num;
                    n[i][j]=num;
                }
                else if(i==1){
                    p[i][j]=num>0?num*p[i][j-1]:num*n[i][j-1];
                    n[i][j]=num>0?num*n[i][j-1]:num*p[i][j-1];
                }
                else if(j==1){
                    p[i][j]=num>0?num*p[i-1][j]:num*n[i-1][j];
                    n[i][j]=num>0?num*n[i-1][j]:num*p[i-1][j];
                }
                else{
                    p[i][j]=num*(num>0?Math.max(p[i][j-1],p[i-1][j]):Math.min(n[i][j-1],n[i-1][j]));
                    n[i][j]=num*(num>0?Math.min(n[i][j-1],n[i-1][j]):Math.max(p[i][j-1],p[i-1][j]));
                }
            }
        }

        long max=p[g.length][g[0].length];
        int mod=(int)Math.pow(10,9)+7;
        if(max<0)
            return -1;
        return (int)(max%mod);
    }
}
