package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/arrange-ii/
/*
Not initializing the array by -1 gave us TLE because the ans could actually be 0 a lot of times but that was getting
 recalculated multiple times. Hence prefer initialising using 0;
 */
public class DP_ib_arrange_horses {
    public int arrange(String s, int k) {
        if(k>s.length()) return -1;
        int dp[][]=new int[s.length()+1][k+1];
        for(int i=0;i<dp.length;++i)
            Arrays.fill(dp[i],-1);
        char ch[]=s.toCharArray();
        arrangeInner(0,k-1,ch,dp);
        // System.out.println(Arrays.deepToString(dp));
        return dp[0][k-1];
    }

    public int arrangeInner(int l, int k, char[]ch, int dp[][]){
        if(dp[l][k]!=-1) return dp[l][k];

        if(k==0){
            int b=0;
            for(int i=l;i<ch.length;++i)
                if(ch[i]=='B')
                    ++b;
            dp[l][k]=b*(ch.length-l-b);
            return dp[l][k];
        }

        int min=Integer.MAX_VALUE;
        int b=0;
        for(int i=l;i<ch.length-k;++i){
            if(ch[i]=='B')
                ++b;
            int t=b*(i-l-b+1)+arrangeInner(i+1,k-1,ch,dp);
            min=Math.min(t,min);
        }
        dp[l][k]=min;
        return dp[l][k];
    }
}
