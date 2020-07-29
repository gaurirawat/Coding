package revision;

//https://leetcode.com/problems/partition-equal-subset-sum/

public class DP_lc_subset_sum_equal_partition {
	public boolean canPartition(int[] nums) {
		if(nums==null || nums.length==0)
			return false;
		int sum= 0;
		for(int x: nums)
			sum+=x;
		if(sum%2==1)
			return false;
		else
			return subsetSumDP(sum/2, nums);
	}

	public boolean subsetSumDP(int sum, int nums[]) {
		boolean dp[][]= new boolean[sum+1][nums.length+1];
		for(int i=1; i<nums.length;++i)
			dp[0][i]=true;
		for(int i=1; i<=sum; ++i){
			for(int j=1; j<=nums.length; ++j){
				if(i>=nums[j-1])
					dp[i][j]=dp[i][j-1] || dp[i-nums[j-1]][j-1];
				else
					dp[i][j]=dp[i][j-1];
			}
		}
		return dp[sum][nums.length];
	}
}
