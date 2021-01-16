package revision;

//https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items/0/?ref=self

import java.util.Arrays;
import java.util.Scanner;

public class DP_gfg_01Knapsack_duplicate_allowed {
    // better approach. Coin change approach
    static int knapSack(int n, int w, int val[], int wt[]) {
        int dp[] = new int[w + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        int max = 0;
        for (int i = 0; i < n; ++i) {
            int currWt = wt[i];
            for (int j = currWt; j <= w; ++j) {
                if (dp[j - currWt] != Integer.MIN_VALUE) {
                    dp[j] = Math.max(dp[j], dp[j - currWt] + val[i]);
                }
                max = Math.max(max, dp[j]);
            }
        }

        return max;
    }

    public static void main (String[] args) {
        Scanner sc =new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String inp[]= sc.nextLine().split(" ");
            int len=Integer.parseInt(inp[0]);
            int wt= Integer.parseInt(inp[1]);
            int value[]= new int[len];
            int weight[]=new int[len];
            String valStr[]=sc.nextLine().split(" ");
            String wtStr[]=sc.nextLine().split(" ");
            for(int i=0; i<len; ++i){
                value[i]= Integer.parseInt(valStr[i]);
                weight[i]= Integer.parseInt(wtStr[i]);
            }
            System.out.println(knapsackDPDuplicateAllowed(value,weight,wt));
        }
    }

    public static int knapsackDPDuplicateAllowed(int value[], int weight[], int wt){
        int dp[][]= new int[value.length+1][wt+1];
        for(int i=1; i<=value.length; ++i){
            for(int j=1; j<=wt; ++j){
                //first case of excluding the element
                dp[i][j]= dp[i-1][j];

                //calculate value by including the element as many times as possible
                for(int k=1; (weight[i-1]*k)<=j; ++k)
                    dp[i][j]= Math.max(dp[i][j], value[i-1]*k + dp[i-1][j-(weight[i-1]*k)]);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[value.length][wt];
    }

}
