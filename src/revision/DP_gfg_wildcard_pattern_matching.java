package revision;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1

/*
weak test cases. Wrong Soln also gets accepted
 */
public class DP_gfg_wildcard_pattern_matching {

    int wildCard(String pattern, String str)
    {
        int dp[][]= new int[str.length()+1][pattern.length()+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        char prr[]= pattern.toCharArray();
        char srr[]= str.toCharArray();
        return wildCardDP(srr,prr,srr.length,prr.length,dp);
    }

    public int wildCardDP(char srr[],char prr[],int s,int p,int[][]dp){
        if(s==0 && p==0) return 1; //both are 0
        if(s==0){                   //s is zero but the pattern should contain just * as remaining stars
            while(p!=0){
                if(prr[p-- -1]!='*')
                    return 0;
            }
            return 1;
        }
        if(p==0) return 0;
        if(dp[s][p]!=-1) return dp[s][p];

        if(prr[p-1]=='?' || prr[p-1]==srr[s-1])
            dp[s][p]=wildCardDP(srr,prr,s-1,p-1,dp);
        else if(prr[p-1]=='*'){
            dp[s][p]=wildCardDP(srr,prr,s-1,p,dp)+ wildCardDP(srr,prr,s-1,p-1,dp)+wildCardDP(srr,prr,s,p-1,dp);
            dp[s][p]=dp[s][p]==0?0:1;
        }
        else
            dp[s][p]=0;
        // System.out.println(s+ " "+ p+ " "+dp[s][p]);
        return dp[s][p];
    }
}
