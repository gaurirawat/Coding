package revision;

//https://leetcode.com/problems/coin-change-2/submissions/

public class DP_lc_coin_change_2 {
	 public int change(int amount, int[] coins) {
	        int dp[]= new int[amount+1];
	        dp[0]=1;
	        for(int c: coins) {
	        	for(int a=c; a<=amount; ++a)
	        		dp[a]=dp[a]+dp[a-c];
	        }
	        return dp[amount];
	 }
	

	/*
	TLE:
	public int change(int amount, int[] coins) {
        int dp[][]= new int[coins.length+1][amount+1];
        return dp(dp, coins, 0, amount); 
    }
    
	public int dp(int dp[][],int[] coins, int i, int amt){
        if(amt==0)
            return 1;
        if(amt<0 ||i==coins.length)
            return 0;
        if(dp[i][amt]==0)
            dp[i][amt]= dp(dp,coins,i, amt-coins[i])+dp(dp, coins,i+1, amt);
        return dp[i][amt];
    }
    */
}
