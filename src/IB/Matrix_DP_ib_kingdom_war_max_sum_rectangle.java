package IB;
//https://www.interviewbit.com/problems/kingdom-war/
public class Matrix_DP_ib_kingdom_war_max_sum_rectangle {
    public int solve(int[][] a) {
        int p[][]=new int[a.length][a[0].length];
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<a.length;++i){
            mx=Math.max(mx,a[i][0]);
            p[i][0]=a[i][0];
            for(int j=1;j<a[0].length;++j){
                p[i][j]=p[i][j-1]+a[i][j];
                mx=Math.max(mx,a[i][j]);
            }
        }
        if(mx<=0) return mx;
        mx=Integer.MIN_VALUE;
        for(int i=0;i<a[0].length;++i)
            for(int j=i;j<a[0].length;++j){
                int curr=0;
                for(int k=0;k<a.length;++k){
                    curr+=i==0?p[k][j]:p[k][j]-p[k][i-1];
                    if(curr<0)
                        curr=0;
                    mx=Math.max(mx,curr);
                }
            }
        return mx;
    }
}