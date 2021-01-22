package revision;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class DP_lc_buy_sell_stock_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] maxProfitFirst = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; ++i) {
            min = Math.min(min, prices[i]);
            maxProfitFirst[i] = Math.max(maxProfitFirst[i - 1], prices[i] - min);
        }

        int[] maxProfitSecond = new int[n];
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            maxProfitSecond[i] = Math.max(maxProfitSecond[i + 1], max - prices[i]);
        }
        int maxProfit = Math.max(maxProfitFirst[n - 1], maxProfitSecond[0]);
        for(int i = 0; i < n - 1; ++i) {
            maxProfit = Math.max(maxProfit, maxProfitFirst[i] + maxProfitSecond[i + 1]);
        }

        return maxProfit;
    }
}
