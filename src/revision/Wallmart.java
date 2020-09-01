package revision;

public class Wallmart {

    public static void main(String[] args) {
        int x=4;
        System.out.println(solve(x));
    }

    static int mod=(int)Math.pow(10,9)+7;
    static int solve(int N){
        int dp[]=new int[N+1];
        return innerSolve(N, dp);
    }

    static int innerSolve(int n, int dp[]){
        if(n<=0)return 0;
        if(n<=1)return 1;
        if(dp[n]!=0) return dp[n];

        long c=0l;
        for(int i=n;i>=1;--i){
            c=(c+1)%mod;
            c=(c+innerSolve(i-2,dp))%mod;
        }
        dp[n]=(int)(c%mod);
        return dp[n];
    }
}
