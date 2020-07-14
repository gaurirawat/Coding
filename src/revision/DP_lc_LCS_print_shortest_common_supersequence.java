package revision;

//https://leetcode.com/problems/shortest-common-supersequence/
public class DP_lc_LCS_print_shortest_common_supersequence {

	public String shortestCommonSupersequence(String str1, String str2) {
        char[]xrr= str1.toCharArray();
        char[]yrr=str2.toCharArray();
        int dp[][]= new int[xrr.length+1][yrr.length+1];
        longestCommonSubsequenceDP(xrr,yrr,dp);
        return getShortestCommonSupersequence(xrr,yrr,dp);
    }
    
    public int longestCommonSubsequenceDP(char[]xrr,char[]yrr, int dp[][]){
        for(int i=1; i<=xrr.length;++i){
            for(int j=1; j<=yrr.length; ++j){
                if(xrr[i-1]==yrr[j-1])
                    dp[i][j]= dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[xrr.length][yrr.length];
    }
    
    public String getShortestCommonSupersequence(char[]xrr, char[]yrr, int dp[][]){
        int i=xrr.length;
        int j=yrr.length;
        String s="";
        while(i>0 &&j>0){
            if(xrr[i-1]==yrr[j-1]){
                s=xrr[i-1]+s;
                --i;
                --j;
            }
            else if(dp[i][j]==dp[i][j-1]){
                s=yrr[j-1]+s;
                j--;
            }
            else{
                s=xrr[i-1]+s;
                i--;
            }
        }
        while(i>0)
            s=xrr[i-- -1]+s;
        while(j>0)
            s=yrr[j-- -1]+s;
        return s;
    }
}
