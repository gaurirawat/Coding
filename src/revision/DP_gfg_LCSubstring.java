package revision;
//https://practice.geeksforgeeks.org/problems/longest-common-substring/0

import java.util.Scanner;

public class DP_gfg_LCSubstring {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            sc.nextLine();
            String a=sc.nextLine();
            String b=sc.nextLine();
            System.out.println(longestCommonSubstringDP(a,b));
        }
    }

    public static int longestCommonSubstringDP(String a, String b){
        int la=a.length();
        int lb=b.length();
        int dp[][]= new int[la+1][lb+1];
        int max=0;
        for(int i=0;i< la;++i){
            for(int j=0;j< lb;++j){
                if(a.charAt(i)==b.charAt(j))
                    dp[i+1][j+1]=dp[i][j]+1;
                max=Math.max(dp[i+1][j+1], max);
            }
        }
        return max;
    }
}