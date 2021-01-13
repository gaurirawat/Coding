package revision;

public class DP_lc_balloon_burst_matrix_multiplication {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] num = new int[len+2];
        for (int i=0; i<len; ++i) {
            num[i+1] = nums[i];
        }
        len+=2;
        num[0]=1;
        num[len-1]=1;
        int dp[][] =  new int[len][len];
        return maxCoinInner(dp, num, 1, len-2);
    }

    public  int maxCoinInner(int[][] dp, int[] num, int l, int r) {
        if(l>r) {
            return 0;
        }
        if(dp[l][r]!=0) {
            return dp[l][r];
        }

        int max = num[l-1]*num[l]*num[r+1];
        for(int i=l;i<=r;++i) {
            max=Math.max(max, num[l-1]*num[i]*num[r+1] + maxCoinInner(dp, num, l, i-1)+
                    maxCoinInner(dp, num, i+1, r));

        }
        dp[l][r]=max;
        return dp[l][r];
    }
}
