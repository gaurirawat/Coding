package IB;
//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
public class DP_ib_buy_sell_stock_2 {
    public int maxProfit(final int[] a) {
        if(a.length==0||a.length==1) return 0;
        int dpl[]=new int[a.length];
        int min=a[0];
        for(int i=1;i<a.length;++i){
            if(a[i]<min){
                dpl[i]=dpl[i-1];
                min=a[i];
            }
            else
                dpl[i]=Math.max(dpl[i-1],a[i]-min);
        }

        int max=a[a.length-1];
        int dpr[]=new int[a.length];
        for(int i=a.length-2;i>=0;--i){
            if(a[i]<=max)
                dpr[i]=Math.max(dpr[i+1],max-a[i]);
            else{
                dpr[i]=dpr[i+1];
                max=a[i];
            }
        }

        int ans=dpl[a.length-1];
        for(int i=0;i<a.length-1;++i)
            ans=Math.max(ans, dpl[i]+dpr[i+1]);
        return ans;
    }
}
