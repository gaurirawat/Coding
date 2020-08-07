package revision;
//https://leetcode.com/problems/stone-game-iv/
public class DP_lc_stone_game {
    public boolean winnerSquareGame(int n) {
        int dp[]=new int[n+1];
        return winnerSquareGameDP(n, dp);
    }

    public boolean winnerSquareGameDP(int n, int[]dp){
        if(n==0) return false;
        if(n==1) return true;
        if(dp[n]!=0) return dp[n]==1?true:false;
        boolean othWin=true;
        for(int i=1;i*i<=n;++i)
            othWin=othWin&&winnerSquareGameDP(n-i*i,dp);

        if(othWin==false)
            dp[n]=1;
        else
            dp[n]=-1;
        return !othWin;
    }
}
