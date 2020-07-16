package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0
public class DP_gfg_egg_Dropping {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String s[] = sc.nextLine().split(" ");
            int e = Integer.parseInt(s[0]);  //No of eggs.
            int f = Integer.parseInt(s[1]);  //No of floors.

            if(e==1) {
                System.out.println(f);
                continue;
            }
            int dp[][]= new int[e+1][f+1];
            System.out.println(eggDropDP(e,f,dp));
        }
    }

    public static int eggDropDP(int e, int f,int dp[][]){
        if(e==1|| f==0||f==1)
            return f;
        if(dp[e][f]!=0)
            return dp[e][f];
        dp[e][f]=Integer.MAX_VALUE;
        for(int i=1; i<=f;++i){
            int x=Math.max(eggDropDP(e-1,i-1,dp), eggDropDP(e,f-i,dp));
            dp[e][f]=Math.min(dp[e][f],1+x);//adding one since the current drop should also be counted
        }
        return dp[e][f];
    }
}
