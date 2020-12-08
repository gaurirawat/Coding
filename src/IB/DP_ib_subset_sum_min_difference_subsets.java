package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/minimum-difference-subsets/
public class DP_ib_subset_sum_min_difference_subsets {
    public int solve(int[] a) {
        int sum=0;
        for(int x:a){
            sum+=x;
        }
        int half=sum/2;
        int max=subsetSum(half,a);
        return Math.abs(max-(sum-max));
    }

    public int subsetSum(int s, int[] a){
        boolean[][] dp= new boolean[s+1][a.length+1];
        Arrays.fill(dp[0],true);
        int max=0;
        for(int i=1;i<=s;++i) {
            for(int j=1;j<=a.length;++j) {
                dp[i][j]=dp[i][j-1];
                if(a[j-1]<=i){
                    dp[i][j]=dp[i][j]||dp[i-a[j-1]][j-1];
                }
                if(dp[i][j]){
                    max=i;
                }
            }
        }
        return max;
    }
}