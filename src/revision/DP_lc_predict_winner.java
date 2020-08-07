package revision;
//https://www.youtube.com/watch?v=fEwAmdnBArQ
//https://leetcode.com/problems/predict-the-winner/
public class DP_lc_predict_winner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length==1)
            return true;

        /*dp[l][r] stores max value possible for that pair of l and r
        irrespective of that being for whichever player.*/
        int dp[][]= new int[nums.length][nums.length];

        int tot=0;
        for(int x: nums)
            tot+=x;
        int x= predictWinnerDP(nums, dp, 0, nums.length-1, tot);
        return x>=Math.ceil(tot/2.0)?true:false;
    }

    public int predictWinnerDP(int[]nums, int[][]dp, int l, int r, int tot){
        if(l>r)
            return 0;
        if(l==r)
            return nums[l];
        if(dp[l][r]!=0)
            return dp[l][r];
        int otherPlayerSum=Math.min(predictWinnerDP(nums, dp, l+1,r,tot-nums[l]), predictWinnerDP(nums, dp, l,r-1,tot-nums[r]));
        return dp[l][r]=tot-otherPlayerSum;
    }
}
