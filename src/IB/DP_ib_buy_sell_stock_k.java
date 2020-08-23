package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stock-atmost-b-times/
public class DP_ib_buy_sell_stock_k {
    public int solve(ArrayList<Integer> l, int k) {
        if(k==0||l.size()==0) return 0;

        if(k>=l.size()/2){
            int sum=0;
            for(int i=1;i<l.size();++i){
                int diff=l.get(i)-l.get(i-1);
                sum+=diff>0?diff:0;
            }
            return sum;
        }

        int dp[][]=new int[k+1][l.size()+1];
        for(int i=1;i<=k;++i){
            int pr=0-l.get(0);
            for(int j=1; j<=l.size();++j){
                dp[i][j]=Math.max(dp[i][j-1], pr+l.get(j-1));
                pr=Math.max(pr, dp[i-1][j-1]-l.get(j-1));
            }
        }
        return dp[k][l.size()];
    }
}
