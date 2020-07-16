package revision;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/

public class Array_lc_buy_sell_stock_infinite_times {
    public int maxProfit(int[] pr) {
        int v=0;
        int p=0;
        int sum=0;

        int i=0;
        while(i<pr.length-1){
            while(i<pr.length-1 && pr[i]>=pr[i+1])
                i++;
            v=pr[i];
            while(i<pr.length-1 && pr[i]<=pr[i+1])
                i++;
            p=pr[i];
            sum+=(p-v);
        }
        return sum;

    }
}
