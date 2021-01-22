package revision;

//https://leetcode.com/problems/partition-equal-subset-sum/

public class DP_lc_subset_sum_equal_partition {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num :nums) {
			sum += num;
		}

		if (sum % 2 != 0) {
			return false;
		}

		sum /= 2;
		return subsetSum(nums, sum);
	}

	public boolean subsetSum(int[] nums, int sum) {
		boolean dp[][] = new boolean[nums.length + 1][sum + 1];
		for (boolean[]arr : dp) {
			arr[0] = true;
		}

		for (int i = 1; i <= nums.length; ++i) {
			for (int j = 1; j <= sum; ++j) {
				dp[i][j] = dp[i - 1][j];
				if (!dp[i][j] && nums[i - 1] <= j) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}

		return dp[nums.length][sum];
	}
}
