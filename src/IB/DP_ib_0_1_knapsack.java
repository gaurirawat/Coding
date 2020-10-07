package IB;
//https://www.interviewbit.com/problems/0-1-knapsack/
import java.util.*;

public class DP_ib_0_1_knapsack {
    public int solve(int[] cost, int[] wt, int w) {
        ArrayList<Item> l= new ArrayList<Item>();
        for(int i=0;i<cost.length;++i)
            l.add(new Item(cost[i],wt[i]));
//        Collections.sort(l, Comparator.comparingInt(a->a.wt));

        int dp[][]=new int[w+1][cost.length+1];
        for(int i=1;i<=w;++i){
            for(int j=1;j<=cost.length;++j){
                dp[i][j]=dp[i][j-1];
                if(l.get(j-1).wt<=i)
                    dp[i][j]=Math.max(dp[i][j], l.get(j-1).cost+dp[i-l.get(j-1).wt][j-1]);
            }
        }
        return dp[w][cost.length];
    }
}
class Item{
    int cost;
    int wt;
    public Item(int a, int b){
        cost=a;
        wt=b;
    }
}