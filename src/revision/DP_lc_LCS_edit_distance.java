package revision;

import java.util.Arrays;
//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
//https://leetcode.com/problems/edit-distance/submissions/
public class DP_lc_LCS_edit_distance {
    public int minDistance(String str1, String str2) {
        char[]xrr= str1.toCharArray();
        char[]yrr=str2.toCharArray();
        int dp[][]= new int[xrr.length+1][yrr.length+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return editDistanceDP(xrr,yrr,dp, xrr.length, yrr.length);
    }

    public int editDistanceDP(char[]xrr,char[]yrr, int dp[][], int i, int j){
        if(i<=0)
            return j;
        if(j<=0)
            return i;
        if(dp[i][j]!=-1)
            return dp[i][j];

        if(xrr[i-1]==yrr[j-1])
            dp[i][j]=editDistanceDP(xrr, yrr,dp,i-1,j-1);
        else
            //1 is added since the current op is being considered
            dp[i][j]= 1+ Math.min(editDistanceDP(xrr,yrr, dp, i-1,j),//delete element from x to become y
                            Math.min(editDistanceDP(xrr,yrr, dp, i,j-1),//add element to x to become y
                            editDistanceDP(xrr,yrr, dp, i-1,j-1)));//replace element x with y
        return dp[i][j];
    }

}
