package revision;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
public class DP_gfg_01Knapsack {
    public static void main (String[] args) {
        Scanner sc =new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len = Integer.parseInt(sc.nextLine());
            int wt= Integer.parseInt(sc.nextLine());
            int value[]= new int[len];
            int weight[]=new int[len];
            String valStr[]=sc.nextLine().split(" ");
            String wtStr[]=sc.nextLine().split(" ");
            for(int i=0; i<len; ++i){
                value[i]= Integer.parseInt(valStr[i]);
                weight[i]= Integer.parseInt(wtStr[i]);
            }
            System.out.println(knapsackDP(value, weight, wt));
        }
    }

    public static int knapsackDP(int value[], int weight[], int wt){
        int dp[][]= new int[value.length+1][wt+1];
        for(int i=1; i<=value.length; ++i){
            for(int j=1; j<=wt; ++j){
                dp[i][j]= Math.max(dp[i-1][j],
                        weight[i-1]<=j? (value[i-1]+dp[i-1][j-weight[i-1]]):0);
            }
        }
        return dp[value.length][wt];
    }
}