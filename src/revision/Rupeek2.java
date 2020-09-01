package revision;

import java.util.Arrays;
import java.util.Scanner;

public class Rupeek2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String s[]=sc.nextLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            int dp[][]=new int[n+1][k+1];
            System.out.println(solve(n,k,dp));
        }
    }
    public static int solve(int n, int k, int dp[][]){
        if(n<0) return 0;
        if(n==1||n==0) return 1;
        if(dp[n][k]!=0) return dp[n][k];
        int mod=(int)Math.pow(10,9)+7;
        long x=solve(n-1,k,dp);
        x+=solve(n-2,k,dp);
        if(k>n/3)
            x+=solve(n-3,k,dp);
        else if(k>0)
            x+=solve(n-3,k-1,dp);
        dp[n][k]=(int)(x%mod);
        return dp[n][k];
    }
}
/*
5
7 3
4 2
3 3
7 1
2 3
 */