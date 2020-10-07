
package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/chain-of-pairs/
public class DP_ib_chain_of_pairs {
    public int solve(ArrayList<ArrayList<Integer>> a) {
        int dp[]=new int[a.size()];
        int max=0;
        for(int i=0;i<a.size();++i){
            int currmax=0;
            for(int j=0;j<i;++j)
                if(a.get(j).get(1)<a.get(i).get(0))
                    currmax=Math.max(currmax,dp[j]);
            dp[i]=1+currmax;
            max=Math.max(max, dp[i]);
        }
        return max;
    }
}
