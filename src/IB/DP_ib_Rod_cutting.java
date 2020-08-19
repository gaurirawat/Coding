package IB;

import java.util.*;

public class DP_ib_Rod_cutting {
    public ArrayList<Integer> rodCut(int n, ArrayList<Integer> ls) {
        if(ls.size()==0) return new ArrayList<Integer>();
        Collections.sort(ls);
        ls.add(0,0);
        ls.add(n);

        SumI dp[][]=new SumI[ls.size()][ls.size()];
        rodCutDP(0,ls.size()-1,ls,dp);
        ArrayList<Integer> ans=new ArrayList<Integer>();
        getResult(0,ls.size()-1,ans,dp,ls);
        return ans;
    }

    public int rodCutDP(int li, int ri, ArrayList<Integer> ls, SumI dp[][]){
        if(li+1==ri) return ls.get(ri)-ls.get(li);
        if(dp[li][ri]!=null) return dp[li][ri].sum;

        int sum=Integer.MAX_VALUE;
        int index=0;
        for(int i=li+1;i<ri;++i){
            int t=rodCutDP(li,i,ls,dp)+rodCutDP(i,ri,ls,dp);
            if(t<sum){
                index=i;
                sum=t;
            }
        }

        sum+=ls.get(ri)-ls.get(li);
        dp[li][ri]=new SumI(index,sum);
        return dp[li][ri].sum;
    }

    public void getResult( int li, int ri,ArrayList<Integer> ans, SumI dp[][],ArrayList<Integer> ls){
        if(li+1==ri) return;
        ans.add(ls.get(dp[li][ri].index));
        getResult(li,dp[li][ri].index,ans,dp,ls);
        getResult(dp[li][ri].index,ri,ans,dp,ls);
    }

}

class SumI{
    int index;
    int sum;
    public SumI(int x, int y){
        index=x;
        sum=y;
    }
}