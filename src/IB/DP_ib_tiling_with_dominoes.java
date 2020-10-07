package IB;
//https://www.interviewbit.com/problems/tiling-with-dominoes/
public class DP_ib_tiling_with_dominoes {
    public int solve(int n) {
        if(n<=1) return 0;
        int mod=(int)Math.pow(10,9)+7;
        long a[]=new long[n+1];
        long b[]=new long[n+1];
        a[0]=1;a[1]=0;
        b[0]=0;b[1]=1;
        for(int i=2;i<=n;++i){
            a[i]=a[i-2]+2*b[i-1];
            b[i]=a[i-1]+b[i-2];
            a[i]%=mod;
            b[i]%=mod;
        }
        return (int)a[n];
    }
}