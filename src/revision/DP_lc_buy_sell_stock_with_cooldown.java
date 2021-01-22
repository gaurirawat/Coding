package revision;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
/*
Same logic of max as in sell buy atmost k.
prices[i] = max profit at position i.
Now, profit[i]  = max(profit[i - 1], prices[i] - prices[j] + profit[j - 2]) for all j that are less than i)
                = max(profit[i - 1], prices[i] + max (profit[j - 2] - prices[j]) where j < i)
*/

import java.util.Arrays;

public class DP_lc_buy_sell_stock_with_cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int profit[] = new int[n + 1];

        int maxElem = 0 - prices[0];
        for (int i = 2; i <= n; ++i) {
            profit[i] = Math.max(profit[i - 1], prices[i - 1] + maxElem);
            maxElem = Math.max(maxElem, profit[i - 2] - prices[i - 1]);
        }
        System.out.println(Arrays.toString(profit));
        return profit[n];
    }
}
