package revision;
import java.util.*;

//https://leetcode.com/problems/longest-increasing-subsequence/submissions/
public class Array_lc_LIS {
	public int lengthOfLIS(int[] nums) {
        int dp[]= new int[nums.length];
        int len=0;
        for(int n: nums){
            int x= Arrays.binarySearch(dp, n);
            if(x<0) 
            	x=-(x+1);
            dp[x]= n;
            if(len==x)
            	++len;
        }
        return len;
    }
}
