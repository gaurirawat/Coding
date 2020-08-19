package IB;
//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
public class DP_ib_buy_sell_stock_1 {
    public int maxProfit(final int[] a) {
        int min=Integer.MAX_VALUE;
        int maxP=0;
        for(int x:a){
            maxP=Math.max(maxP, x-min);
            min=Math.min(min, x);
        }
        return maxP;
    }
}
