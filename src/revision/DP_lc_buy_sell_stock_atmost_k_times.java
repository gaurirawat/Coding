package revision;

import java.util.*;

//Array_lc_buy_sell_stock_1_time
//Array_lc_buy_sell_stock_infinite_times
//DP_lc_buy_sell_stock_atmost_2_times use same code for k=2
//DP_lc_buy_sell_stock_atmost_k_times

/*
So first the dp matrix is initiated as int[i][j] -> int[k + 1][len], which actually means for the ith transaction till jth stock,
the maximum profit we can gain. This is not hard to understand. And we can also know that for 0th transaction and any time of
tractions till 0th stock, we gain nothing. So the initial value of all 0 works fine.

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
t[i - 1][j - 1], and then buy the tock, to get our debt at ith transaction and jth` stock.
*/

//ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
public class DP_lc_buy_sell_stock_atmost_k_times {
    public int maxProfit(int k, int[] pr) {
        if(pr==null||pr.length==0||k==0)
            return 0;
        if(k>=pr.length/2){
            int sum=0;
            for(int i=1;i<pr.length;++i)
                if(pr[i]>pr[i-1])
                    sum+=pr[i]-pr[i-1];
            return sum;
        }

        int dp[][]= new int[k+1][pr.length];
        for(int i=1;i<=k;++i){
            int currp=-pr[0];//current profit. negative since we are purchasing the first element
            for(int j=1;j<pr.length;++j){
                dp[i][j]=Math.max(dp[i][j-1], currp+pr[j]);
                currp= Math.max(currp,dp[i-1][j-1]-pr[j]);
            }
        }
        return dp[k][pr.length-1];
    }
}

/* below code is working fine for small inputs but is giving TLE for bigger inputs even in gfg
public int maxProfit(int k, int[] pr) {
        if(pr==null||pr.length<=1||k==0) return 0;
        int dp[][]= new int[pr.length+1][k+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));

        ArrayList<Integer> p= new ArrayList<Integer>();
        ArrayList<Integer> v= new ArrayList<Integer>();
        int i=0;

        while(i<pr.length-1){
            //add index of all valleys in an arrayList v
            while(i<pr.length-1 && pr[i]>=pr[i+1])
                i++;

            if(i==0||pr[i-1]>=pr[i])
                v.add(i);


            //add index of all peaks in an arrayList p
            while(i<pr.length-1 && pr[i]<=pr[i+1])
                i++;
            if(pr[i-1]<=pr[i])
                p.add(i);
        }

        System.out.println("valley:"+v.toString());
        System.out.println("peak:"+p.toString());

        if(p.size()==0) return 0;
        return maxProfitDP(pr,p,v, dp, 0, k);
    }

    public int maxProfitDP( int pr[],ArrayList<Integer> p, ArrayList<Integer> v, int dp[][], int i, int k){
        if(i>=pr.length-1) return 0;
        if(k==0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];

        //find the index of closest valley
        int nv=Collections.binarySearch(v,i);
        if(nv<0)
            nv=Math.abs(nv+1);

        //if valley doesn't exist return 0;
        if(nv>=v.size())
            return dp[i][k]=0;

        //if valley exists and cell is not the valley then return max profit for that valley else calculate
        if(i!=v.get(nv)) {
            System.out.println("going to valley at i:" +v.get(nv));
            return dp[i][k] = maxProfitDP(pr, p, v, dp, v.get(nv), k);
        }

        //If we are here then this cell is the valley
        int mxProf=0;

        //we buy stock at this valley. May sell it at any of the peaks.
        int np=Collections.binarySearch(p,i);
        if(np<0)
            np=Math.abs(np+1);

        while(np<p.size()){
            int crProf=pr[p.get(np)]-pr[v.get(nv)]+maxProfitDP(pr,p,v,dp,p.get(np)+1,k-1);
            np++;
            mxProf=Math.max(mxProf,crProf);
        }

        //we don't buy stock at this valley
        if(nv+1<v.size())
            mxProf=Math.max(mxProf,maxProfitDP(pr,p,v,dp,v.get(nv+1),k));

        System.out.println(i+" "+k+" "+mxProf);
        return dp[i][k]=mxProf;
    }

    public static void main(String[] args) {
        DP_lc_buy_sell_stock_atmost_k_times obj = new DP_lc_buy_sell_stock_atmost_k_times();
        int a[]={2,4,1};
        System.out.println(obj.maxProfit(2,a));
    }
 */
