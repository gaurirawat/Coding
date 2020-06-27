package revision;

//https://leetcode.com/problems/longest-increasing-subsequence/

/*better method: 
https://leetcode.com/problems/longest-increasing-subsequence/discuss/74825/Short-Java-solution-using-DP-O(n-log-n)
The idea is that as you iterate the sequence, you keep track of the minimum value a subsequence of given length 
might end with, for all so far possible subsequence lengths. So dp[i] is the minimum value a 
subsequence of length i+1 might end with. Having this info, for each new number we iterate to, 
we can determine the longest subsequence where it can be appended using binary search. The final answer
is the length of the longest subsequence we found so far.The idea is that as you iterate the sequence,
you keep track of the minimum value a subsequence of given length might end with, for all so far
possible subsequence lengths. So dp[i] is the minimum value a subsequence of length i+1 might end
with. Having this info, for each new number we iterate to, we can determine the longest subsequence
 where it can be appended using binary search. The final answer is the length of the longest subsequence we found so far.

https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
*/

import java.util.*;
public class DP_lc_LIS {
	public int lengthOfLIS(int[] nums) {
		int brr[]= Arrays.copyOf(nums, nums.length);
		Arrays.sort(brr);
        return integerLCS(nums, brr);
    }
	
	public int integerLCS(int arr[], int brr[]) {
		int dp[]= new int[brr.length+1];
		for(int i=1; i<=arr.length; ++i) {
			int prev=0;
			for(int j =1; j<=brr.length; ++j) {
				int temp=dp[j];
				if(arr[i-1]==brr[j-1] && (j==1 || (j!=1 && brr[j-1]!= brr[j-2])))
					dp[j]=prev+1;
				else
					dp[j]= Math.max(dp[j], dp[j-1]);
				prev=temp;
			}
		}
		return dp[brr.length];
	}
}
