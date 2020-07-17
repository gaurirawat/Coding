package revision;

//DP_lc_jump_game_isPossible
//Array_lc_jump_game_min_jumps

//https://leetcode.com/problems/jump-game/submissions/

/* below code is mainly to return min length of jumps but it is slow for very large set of nums. The O(n) approach is mentioned in the
above mentioned problem solution
 */

public class DP_lc_jump_game_isPossible {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        int dp[]= new int[nums.length];
        return canJump(nums,dp,0)>=0?true:false;
    }

    public int canJump(int nums[], int dp[], int i){
        if(i==nums.length-1)
            return 0;
        if(i>=nums.length||nums[i]==0)
            return -1;
        if(dp[i]!=0)
            return dp[i];
        dp[i]=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];++j){
            int x=canJump(nums,dp,j+i);
            if(x!=-1)
                dp[i]=Math.min(dp[i],1+x);
        }
        dp[i]= dp[i]==Integer.MAX_VALUE?-1:dp[i];
        return dp[i];
    }
}
