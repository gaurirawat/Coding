package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/coins-in-a-line/
public class DP_ib_coins_in_a_line_choice_game {
    public int maxcoin(ArrayList<Integer> a) {
        int sum=0;
        for(int x:a)
            sum+=x;
        int dp[][]=new int[a.size()+1][a.size()+1];
        return maxCoinInner(a, 0,a.size()-1,sum, dp);
    }

    public int maxCoinInner(ArrayList<Integer> a, int l, int r, int tot, int[][]dp){
        if(l==r) return a.get(l);
        if(dp[l][r]!=0) return dp[l][r];
        int x=maxCoinInner(a,l+1,r,tot-a.get(l),dp);
        int y=maxCoinInner(a,l,r-1, tot-a.get(r),dp);
        if(x>y)
            dp[l][r]= tot-y;
        else
            dp[l][r]= tot-x;
        return dp[l][r];
    }
}
