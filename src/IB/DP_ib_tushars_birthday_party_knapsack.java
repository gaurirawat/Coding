package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/tushars-birthday-party/
public class DP_ib_tushars_birthday_party_knapsack {
    public int solve(final int[] a, final int[] capacity, final int[] cost) {
        int max=0;
        for(int x:a)
            max=Math.max(x,max);

        int dp[][]=new int[max+1][capacity.length+1];
        for(int i=1;i<dp.length;++i)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        knapsack(max,cost,capacity,dp);
        int sum=0;
        for(int x:a)
            sum+=dp[x][capacity.length];
        // System.out.println(Arrays.deepToString(dp));
        return sum;
    }

    public void knapsack(int max, int cost[], int capacity[], int dp[][]){
        for(int i=1;i<=max;++i){
            for(int j=1;j<=capacity.length;++j){
                dp[i][j]=dp[i][j-1];
                for(int k=0;k*capacity[j-1]<=i;++k){
                    if(dp[i-(k*capacity[j-1])][j-1]!=Integer.MAX_VALUE)
                        dp[i][j]=Math.min(dp[i][j], cost[j-1]*k+dp[i-(k*capacity[j-1])][j-1]);
                }
            }
        }
    }
}
