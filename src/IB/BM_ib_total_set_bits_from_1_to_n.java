package IB;
//https://www.interviewbit.com/problems/count-total-set-bits/
public class BM_ib_total_set_bits_from_1_to_n {
    public int solve(int n) {
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<32;++i){
            boolean flag=false;
            int inc=(int)Math.pow(2,i);
            int c=0;
            for(int j=0;j<=n;j+=inc){
                if(flag)
                    c+= (j+inc)<=n ? inc : (n-j)+1;
                flag=!flag;
            }
            ans=(ans+c)%mod;
        }
        return (int)ans;
    }
}
