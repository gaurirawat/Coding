package IB;

import java.util.Arrays;
//https://www.interviewbit.com/problems/coin-sum-infinite/
public class DP_ib_coin_change_infinite_2 {
    public int coinchange2(int[] arr, int amount) {
        int mod=(int)Math.pow(10,6)+7;
        Arrays.sort(arr);
        int dp[]= new int[amount+1];
        dp[0]=1;
        for(int c: arr) {
            for(int a=c; a<=amount; ++a){
                dp[a]=dp[a]+dp[a-c];
                dp[a]%=mod;
            }
        }
        return dp[amount];
    }
}
