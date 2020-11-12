package revision;
//https://practice.geeksforgeeks.org/problems/cutted-segments/0

import java.util.Arrays;
import java.util.Scanner;

public class DP_gfg_max_cut_segments {
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int dp[]=new int[n+1];
        int a=inner(n,x,y,z,dp);
        // System.out.println(Arrays.toString(dp));
        return a==-1?0:a;
    }

    public int inner(int len, int x, int y, int z,int dp[]){
        if(len==0) return 0;
        if(len<0) return -1;
        if(dp[len]!=0) return dp[len];
        int ans=-1;// means invalid partition
        if(len>=x)
            ans=Math.max(ans,inner(len-x,x,y,z,dp));
        if(len>=y)
            ans=Math.max(ans,inner(len-y,x,y,z,dp));
        if(len>=z)
            ans=Math.max(ans,inner(len-z,x,y,z,dp));
        dp[len]=ans==-1?-1:(ans+1);
        return dp[len];
    }
}


















