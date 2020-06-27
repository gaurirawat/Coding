package revision;

//https://leetcode.com/problems/partition-equal-subset-sum/

public class DP_lc_subset_sum_equal_partition {
	public boolean canPartition(int[] nums) {
		int sum=0;
		for(int n:nums)
			sum+=n;
        if(sum%2==1)
            return false;
		sum/=2;
		return subsetSumDP(sum,nums);
    }
	
	public boolean subsetSumDP(int sum, int nums[]) {
		boolean s[][]= new boolean[sum+1][nums.length+1];
		for(int i=0; i<nums.length; ++i)
			s[0][i]=true;
		for(int i=1; i<=sum;++i) {
			for(int j=1; j<=nums.length;++j) {
				if(i>=nums[j-1])
					s[i][j]= s[i][j-1]||s[i-nums[j-1]][j-1];
				else
					s[i][j]= s[i][j-1];
			}
		}
		return s[sum][nums.length-1];
	}
}
