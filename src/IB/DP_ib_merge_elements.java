package IB;
//https://www.interviewbit.com/problems/merge-elements/
public class DP_ib_merge_elements {
    public int solve(int[] a) {
        for(int i=1;i<a.length;++i){
            a[i]=a[i]+a[i-1];
        }
        int[][] dp=new int[a.length][a.length];
        return getMinCost(0,a.length-1, a, dp);
    }

    public int getMinCost(int l, int r, int[] a, int[][] dp) {
        if(l==r){
            return 0;
        }
        else if(dp[l][r]!=0){
            return dp[l][r];
        }
        int sum=a[r]-(l==0?0:a[l-1]);
        int min=Integer.MAX_VALUE;
        for(int i=l;i<r;++i) {
            min=Math.min(min, getMinCost(l, i, a, dp)+getMinCost(i+1, r, a, dp));
        }
        dp[l][r]=sum+min;
        return dp[l][r];
    }
}
