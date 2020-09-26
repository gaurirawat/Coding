package IB;
//https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
public class DP_ib_intersecting_cords_in_a_circle {
    public int chordCnt(int n) {
        if(n==1) return 1;
        long dp[]=new long[n+1];
        dp[0]=dp[1]=1;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=2;i<=n;++i){
            for(int j=0;j<i;++j)
                dp[i]=(dp[i]+dp[j]*dp[i-j-1])%mod;
        }
        return (int)dp[n];
    }
}