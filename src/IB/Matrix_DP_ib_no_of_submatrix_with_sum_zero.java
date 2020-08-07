package IB;

import java.util.HashMap;
//https://www.interviewbit.com/problems/sub-matrices-with-sum-zero/
public class Matrix_DP_ib_no_of_submatrix_with_sum_zero {
    public int solve(int[][] a) {
        if(a==null||a.length==0) return 0;
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
        if(mx<0) return 0;
        int tcount=0;
        for(int i=0;i<a[0].length;++i)
            for(int j=i;j<a[0].length;++j){
                HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                int psum=0;
                for(int k=0;k<a.length;++k){
                    psum+=i==0?p[k][j]:p[k][j]-p[k][i-1];
                    if(psum==0)
                        tcount++;
                    if(map.get(psum-0)!=null)
                        tcount+=map.get(psum-0);
                    if(map.get(psum)==null)
                        map.put(psum,1);
                    else
                        map.replace(psum, map.get(psum),map.get(psum)+1);
                }
            }
        return tcount;
    }
}
