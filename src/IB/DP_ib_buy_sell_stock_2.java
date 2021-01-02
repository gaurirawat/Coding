package IB;
//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
public class DP_ib_buy_sell_stock_2 {
    public int maxProfit(final int[] a) {
        int len = a.length;
        if (len<=1) {
            return 0;
        }
        int[] ends = new int[len];
        int[] starts = new int[len];

        int min=a[0];
        for (int i = 1 ; i<len ; ++i) {
            min = Math.min(min, a[i]);
            int profit = a[i] - min;
            ends[i] = Math.max(ends[i-1], profit);
        }

        int max = a[len-1];
        for (int i = len-2 ; i >= 0 ; --i) {
            max = Math.max(max, a[i]);
            int profit = max - a[i];
            starts[i] = Math.max(starts[i+1], profit);
        }

        int answer = 0;
        for(int i=1; i< len; ++i) {
            answer = Math.max(answer, ends[i] + (i+1!=len ? starts[i+1] : 0));
        }
        return answer;
    }

}
