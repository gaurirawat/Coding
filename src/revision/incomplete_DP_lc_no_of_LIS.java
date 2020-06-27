package revision;
import java.util.*;
public class incomplete_DP_lc_no_of_LIS {
	
	public int findNumberOfLIS(int[] nums) {
		int brr[]=Arrays.copyOf(nums, nums.length);
		Arrays.sort(brr);
		int arr[]=nums;
		int dp[][]= new int[nums.length+1][nums.length+1];
		int cnt[]= new int[nums.length+1];
		for(int i=1; i<=arr.length; ++i){
			for(int j=1 ;j<= brr.length; ++j){
				if(arr[i-1]==brr[j-1] && (j==1||(brr[j-1]!=brr[j]))){
					dp[i][j]=dp[i-1][j-1]+1;
					cnt[dp[i][j]]++;
				}
				else
					dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		return cnt[dp[nums.length][nums.length]];
    }
}
