package revision;
import java.util.*;

//https://leetcode.com/problems/longest-increasing-subsequence/submissions/
public class Array_lc_LIS {
	public int lengthOfLIS(int[] nums) {
        int dp[]= new int[nums.length+1];
        int len=0;
        for(int x: nums){
            int pos= Arrays.binarySearch(dp,0,len,x);
            if(pos<0)
                pos= -(pos+1);
            dp[pos]=x;
            if(pos==len)
                len++;
        }
        return len;
    }
}
