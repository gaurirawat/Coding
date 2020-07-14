package revision;

//https://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0

import java.util.Scanner;
public class DP_gfg_LCS_length_of_shortest_common_superSequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t--!=0){
            String x= sc.next();
            String y=sc.next();
            int lcs= longestCommonSubsequenceDP(x,y);
            System.out.println(x.length()+y.length()-lcs);
        }
    }

    public static int longestCommonSubsequenceDP(String x, String y){
        char xrr[]= x.toCharArray();
        char yrr[]= y.toCharArray();
        int dp[][]=new int[xrr.length+1][yrr.length+1];
        for(int i=1; i<=xrr.length;++i){
            for(int j=1; j<=yrr.length; ++j){
                if(xrr[i-1]==yrr[j-1])
                    dp[i][j]= dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
//        System.out.println(x+" "+ y+  " "+ dp[xrr.length][yrr.length]);
        return dp[xrr.length][yrr.length];
    }
}
