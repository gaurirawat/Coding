package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/number-of-coins/0

public class DP_gfg_min_coins_to_make_change_with_infinite_supply {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t--!=0){
            int amount= sc.nextInt();
            int len= sc.nextInt();
            int coins[]= new int[len];
            for(int i=0; i< len; ++i){
                coins[i]=sc.nextInt();
            }
            int dp[][]= new int[amount+1][coins.length+1];
            int x= change(dp, amount, coins, 0);
            System.out.println(x==Integer.MAX_VALUE?-1: x);
        }
    }

    //func return max val if sum is not possible
    public static int change(int dp[][],int amt, int coins[],int i){
        if(amt==0) return 0; //here sum is a possibility
        if(i>=coins.length) return Integer.MAX_VALUE;

        if(dp[amt][i+1]==0)
        {
            //element not taken
            dp[amt][i+1]= change(dp, amt, coins, i+1);

            //element taken
            if(amt>=coins[i]){
                int x=change(dp, amt-coins[i], coins, i);
                if(x!=Integer.MAX_VALUE)
                    dp[amt][i+1]=Math.min(dp[amt][i+1],1+x);
            }
        }
        return dp[amt][i+1];
    }

    //bottum up. I cannot decide what initial value to assign.
    /*
    public int coinchange2(int[] arr, int n) {
        int mod=(int)Math.pow(10,6)+7;
        Arrays.sort(arr);
        int dp[][]=new int[2][n+1];
        dp[0][0]=dp[1][0]=1;
        for(int i=1;i<=arr.length;++i){
            for(int j=1;j<=n; ++j)
            {
                long temp=0;
                for(int k=0;k*arr[i-1]<=j;++k){
                    temp+=(dp[(i-1)%2][j-(k*arr[i-1])]);
                    temp=temp%mod;
                }
                dp[i%2][j]=(int)temp;
            }
            // System.out.println(Arrays.toString(dp[i%2]));
        }
        return dp[arr.length%2][n];
    }
    */
}