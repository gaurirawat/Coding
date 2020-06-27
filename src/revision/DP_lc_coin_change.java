package revision;
import java.util.*;
////incomplete
public class DP_lc_coin_change {
	public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int x= calc( coins, coins.length-1, amount);
        return x>=0?x:-1;
    }
    
    public int calc(int[] coins, int i, int amt){
        if(amt==0)
            return 0;
        if(amt<0 ||i==-1)
            return Integer.MIN_VALUE;
        if(amt-coins[i]>-1)
            return 1+ calc(coins,i, amt-coins[i]);
        else
            return calc(coins,i-1, amt);
    }
}