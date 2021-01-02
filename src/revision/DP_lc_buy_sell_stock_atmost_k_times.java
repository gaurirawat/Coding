package revision;

import java.util.*;

//Array_lc_buy_sell_stock_1_time
//Array_lc_buy_sell_stock_infinite_times
//DP_lc_buy_sell_stock_atmost_2_times use same code for k=2
//DP_lc_buy_sell_stock_atmost_k_times

/*
So first the dp matrix is initiated as int[i][j] -> int[k + 1][len], which actually means for the ith transaction till jth stock,
the maximum profit we can gain. This is not hard to understand. And we can also know that for 0th transaction and any time of
transactions till 0th stock, we gain nothing. So the initial value of all 0 works fine.

And the main algorithm is these two lines:

t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
how should we understand that?
What we actually need to calculate is every t[i][j]. And we need to clarify some components here:

tmpMax is before jth stock, the minimum debt (the money we spent on buy stocks) we need to cover. So it should be -prices[0]
at first and negative at all.
t[i][j - 1] is the profit we can gain at ith transaction till j - 1 stock, which is our old profit before dealing with the
jth transaction.
prices[j] + tmpMax is our profit if we are going to sell the jth stock, not hard to understand, just sell + debt(which is negative).
so the problem is how to get minimum debt. Since we are making out debt always negative, so we should always maximize our debt,
which is the reason we are using Math.max. And what is the new debt considering jth stock? Can we use t[i][j - 1] which is
our current profit before jth stock? Actually we can't. That is because if we are using t[i][j - 1], and then we buy jth
stock, we are actually starting a new transaction ( not at ith transaction anymore)! So what we should use is actually
t[i - 1][j - 1], and then buy the stock, to get our debt at ith transaction and jth` stock.
*/

//ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
public class DP_lc_buy_sell_stock_atmost_k_times {
    public int maxProfit(int k, int[] pr) {
        if (pr == null || pr.length == 0 || k == 0)
            return 0;
        if (k >= pr.length / 2) {
            int sum = 0;
            for (int i = 1; i < pr.length; ++i)
                if (pr[i] > pr[i - 1])
                    sum += pr[i] - pr[i - 1];
            return sum;
        }

        int dp[][] = new int[k + 1][pr.length];
        for (int i = 1; i <= k; ++i) {
            int currp = -pr[0];//current profit. negative since we are purchasing the first element
            for (int j = 1; j < pr.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], currp + pr[j]);
                currp = Math.max(currp, dp[i - 1][j - 1] - pr[j]);
            }
        }
        return dp[k][pr.length - 1];
    }
}

/*
BELOW CODE IS MORE UNDERSTANDABLE:

Here basically we put dp[i][j] as max profit possible from the initial j elements using atmost i no of transactions.
dp[i][j]= MIN { dp[i][j-i],   //max profit possible with j-1 transactions
                dp[i-1][k-1]+ a[j]-a[k] for all k(0-><j)    //max profit by making one transaction a[j]-a[k];

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
            for(int j=1; j<=l.size();++j){
                int maxP=0;
                for(int p=1;p<j;++p)
                    maxP=Math.max(maxP, l.get(j-1)-l.get(p-1)+dp[i-1][p-1]);
                dp[i][j]=Math.max(dp[i][j-1], maxP);
            }
        }
        return dp[k][l.size()];
    }
 */
