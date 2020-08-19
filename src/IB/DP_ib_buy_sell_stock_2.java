package IB;
//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
public class DP_ib_buy_sell_stock_2 {
    public int maxProfit(final int[] a) {
        int pr=0;
        for(int i=1;i<a.length;++i)
            if(a[i]>a[i-1])
                pr+=(a[i]-a[i-1]);
        return pr;
    }
}
