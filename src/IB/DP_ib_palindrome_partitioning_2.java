package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/palindrome-partitioning-ii/
public class DP_ib_palindrome_partitioning_2 {
    public int minCut(String a) {
        if(a.length()<0) return 0;
        char ch[]=a.toCharArray();
        int dp[]=new int[ch.length];
        Arrays.fill(dp,ch.length-1);
        dp[0]=0;
        for(int i=0;i<ch.length;++i){
            dp[i]=Math.min(dp[i],i==0?0:(dp[i-1]+1));
            int l=i,r=i+1;
            while(l>=0 && r<=ch.length-1 && ch[l]==ch[r]){
                l--;
                r++;
                dp[r-1]=Math.min(dp[r-1],(l==-1?0:(dp[l]+1)) );
            }

            l=i-1;r=i+1;
            while(l>=0 && r<=ch.length-1 && ch[l]==ch[r]){
                l--;
                r++;
                dp[r-1]=Math.min(dp[r-1],(l==-1?0:(dp[l]+1)) );
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[ch.length-1];
    }
}
